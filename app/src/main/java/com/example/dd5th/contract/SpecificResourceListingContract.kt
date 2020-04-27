package com.example.dd5th.contract

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.example.dd5th.data.domain.ApiListItemResponse

interface SpecificResourceListingContract {

    interface View {
        fun showList(list: ArrayList<ApiListItemResponse>)
        fun setActionBarTitle(title: String)
    }
    interface Presenter {
        fun getList(resourceName: String)
        fun getExtras(extras: Bundle?): String?
        fun getItemActivity(context: Context, resourceItem: String): Intent?
    }
    interface Callback {
        fun onSuccess(list: ArrayList<ApiListItemResponse>)
        fun onError()
        fun onFailure()
    }
    interface Api {
        fun listResourceItems(resourceName: String, callback: Callback)
    }

}