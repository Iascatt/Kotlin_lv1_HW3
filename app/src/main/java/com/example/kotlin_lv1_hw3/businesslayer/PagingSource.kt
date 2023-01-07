package com.example.kotlin_lv1_hw3.businesslayer

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.kotlin_lv1_hw3.datalayer.IAccessor
import com.example.kotlin_lv1_hw3.objects.Article

class PagingSource(
    val backend: IAccessor
) : PagingSource<Int, Article>() {
    override suspend fun load(
        params: LoadParams<Int>
    ): LoadResult<Int, Article> {

        try {
            // Start refresh at page 1 if undefined.
            val nextPageNumber = params.key ?: 1
            val articles = backend.getArticles()

            val nextKey =
                if (articles.isEmpty()) {
                    null
                } else {
                    // By default, initial load size = 3 * NETWORK PAGE SIZE
                    // ensure we're not requesting duplicating items at the 2nd request
                    nextPageNumber + 1
                }
            return LoadResult.Page(
                data = articles,
                prevKey = null, // Only paging forward.
                nextKey = nextKey
            )
        } catch (exception: Throwable) {
            return LoadResult.Error(exception)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        // Try to find the page key of the closest page to anchorPosition, from
        // either the prevKey or the nextKey, but you need to handle nullability
        // here:
        //  * prevKey == null -> anchorPage is the first page.
        //  * nextKey == null -> anchorPage is the last page.
        //  * both prevKey and nextKey null -> anchorPage is the initial page, so
        //    just return null.
        return state.anchorPosition?.let { anchorPosition ->
            val anchorPage = state.closestPageToPosition(anchorPosition)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}