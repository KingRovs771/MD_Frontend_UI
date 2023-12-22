package aplikasi.data.api.paging

import android.util.Log
import androidx.paging.PagingSource
import androidx.paging.PagingState
import aplikasi.data.api.ApiService
import aplikasi.data.api.UmkmData

class UmkmPagingResource(private val apiService : ApiService) : PagingSource<Int,UmkmData>() {

    private companion object {
        const val INITIAL_PAGE_INDEX = 1
    }
    override fun getRefreshKey(state: PagingState<Int, UmkmData>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, UmkmData> {
        return try {
            val position = params.key ?: INITIAL_PAGE_INDEX
            val response = apiService.getUmkmHome()
            val responseData = response.values as List<UmkmData>
            Log.d("CALL BY RESUME","ENTAH BAGAIMANA SAYA DI PANGGIL")
            LoadResult.Page(
                data = responseData,
                prevKey = if (position == INITIAL_PAGE_INDEX) null else position - 1,
                nextKey = if (responseData.isEmpty()) null else position + 1
            )
        } catch (exception: Exception) {
            return LoadResult.Error(exception)
        }
    }
}