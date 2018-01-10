package com.kotlinexample.api

data class ProductInfoModel(val id: Long,
                       val img: String,
                       val text: String,
                       val title: String)

object ProductSingleton {
    var id: Long = 0
    var img: String = ""
    var text: String = ""
    var title: String = ""

}

data class ProductReviewModel(val id: Long,
                              val product: Long,
                              val created_by: CreatedByModel,
                              val rate: Int,
                              val text: String)

data class CreatedByModel(val id: Long,
                          val username: String)

data class PostReviewModel(val rate: Int,
                           val text: String)

data class PostReviewResponseModel(val review_id: Long)