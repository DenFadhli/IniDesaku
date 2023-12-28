package com.citiasia.inidesakubeta.data.database

import android.util.Log

object DetailWisata {
    private val data = arrayOf(
        arrayOf(
            "Sampel Wisata Desa 1",
            "https://s3-alpha-sig.figma.com/img/ec4c/b64f/f2232937b3cb5cde77430094d2d90e46?Expires=1703462400&Signature=KQKuV9RLZtxMRDfRGMaC1~nssbX9js9Gdkv~OncF6zbCf7xcBbTlXNNWALLXwXpqrg~nNtgNkugQ9sFZNHo~m1zu9IuQwnyOJZLjz5VjVb-jeQZAv80hEgizKzLTgsJ0fSzjTg14nQQFgk~zkgit-Er6pnyxMwBCT6MDnm~7apNRaa9tB~63KSTYoiyOmyymYcpnfKekhpN58XFytQo4Q~qjkLyKyolBNd7q-v8iMZmOkqIqAuZExt28-rWvowiZwCkRyAtkQrXlS~yQV3n7qGP8SbAK4go-0-msinhYPyVP57TKaoiHegllSlBNXBP0SzJXg91SQLEHFaWOmtMNng__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
            "Jl. Indramayu",
            "11:00 WIB - 22:00 WIB",
            "Semua Umur",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce aliquam efficitur euismod. Vivamus scelerisque et urna scelerisque volutpat. Mauris volutpat varius eros, et condimentum leo varius et. Maecenas tincidunt ligula metus, porttitor condimentum neque interdum at. Morbi est nisi, pulvinar vel rutrum quis, dignissim nec libero. Suspendisse eget hendrerit orci. Pellentesque et vestibulum ex. Donec posuere lorem diam, volutpat imperdiet urna ornare nec. Nunc at tellus eros.\n" +
                    "Duis viverra ornare rutrum. Suspendisse sagittis, sem sed sagittis pretium, odio ante tempor dui, vel porta mauris leo non libero. Praesent aliquam maximus sem nec auctor. Morbi eget euismod ante, non dapibus diam. Nullam posuere consequat orci, et eleifend neque tempus vitae. Curabitur vitae congue lacus, a consequat mi. Suspendisse sapien diam, faucibus eget condimentum et, porta a felis.\n" +
                    "Phasellus sem risus, faucibus sed tellus ac, iaculis aliquet velit. Suspendisse potenti. Vivamus tincidunt ipsum vitae turpis tristique auctor. Pellentesque bibendum vestibulum nulla at finibus. Pellentesque euismod mauris felis, vitae molestie neque sollicitudin et. Sed at urna vulputate, faucibus augue id, malesuada felis. Donec sed pulvinar diam. Sed ante felis, ultrices vel posuere tristique, convallis sit amet urna. Pellentesque non accumsan lectus, vitae placerat metus."
        ),
        arrayOf(
            "Sampel Wisata Desa 2",
            "https://s3-alpha-sig.figma.com/img/3433/00f8/395db9ae3d9241cb27be7682bb04984c?Expires=1703462400&Signature=UpIaWWJcFGBp1lQgnLSjDcsyPoOCb-3YV4-LQCT8MYcyA5i-GoORwDf-XZk7SyYVTsZ8kIcXSgTubbLDqu1p10PwogA6GAfk4jpfI0RR0zG7ODbV91O-dEglMcQQa489ffxv0YpBiFdiC36qsB3mwpSsMRxRc00QgSWT1t6u9e39cx6H0ghYymRMJygDMAlvCRHmNXsfZCcBNec4o0VSoe0Lg3UV7QZRMDlLnvHv0IZ9CSS9c8TpOG1MoUFO4e7KA1qwP~d67Up9U-UNKF6z-qqbLOwtc1b9mO2DpAWqG6g3rtVt7Sd954-saXYSYJg3Za4ckjbkVlCNAlDA34IlRQ__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
            "Jl. Indramayu",
            "11:00 WIB - 22:00 WIB",
            "Semua Umur",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce aliquam efficitur euismod. Vivamus scelerisque et urna scelerisque volutpat. Mauris volutpat varius eros, et condimentum leo varius et. Maecenas tincidunt ligula metus, porttitor condimentum neque interdum at. Morbi est nisi, pulvinar vel rutrum quis, dignissim nec libero. Suspendisse eget hendrerit orci. Pellentesque et vestibulum ex. Donec posuere lorem diam, volutpat imperdiet urna ornare nec. Nunc at tellus eros.\n" +
                    "Duis viverra ornare rutrum. Suspendisse sagittis, sem sed sagittis pretium, odio ante tempor dui, vel porta mauris leo non libero. Praesent aliquam maximus sem nec auctor. Morbi eget euismod ante, non dapibus diam. Nullam posuere consequat orci, et eleifend neque tempus vitae. Curabitur vitae congue lacus, a consequat mi. Suspendisse sapien diam, faucibus eget condimentum et, porta a felis.\n" +
                    "Phasellus sem risus, faucibus sed tellus ac, iaculis aliquet velit. Suspendisse potenti. Vivamus tincidunt ipsum vitae turpis tristique auctor. Pellentesque bibendum vestibulum nulla at finibus. Pellentesque euismod mauris felis, vitae molestie neque sollicitudin et. Sed at urna vulputate, faucibus augue id, malesuada felis. Donec sed pulvinar diam. Sed ante felis, ultrices vel posuere tristique, convallis sit amet urna. Pellentesque non accumsan lectus, vitae placerat metus."
        ),
        arrayOf(
            "Sampel Wisata Desa 3",
            "https://s3-alpha-sig.figma.com/img/61b6/f42e/f3784a6c64c9ca4cef4223ab0ee7ab28?Expires=1703462400&Signature=ZioWf1RgGWlp5aziujXzN7QM3T5kT21RbIo1DL-ikgEPNqlJGM4ngIRHNGAEf9WIuozbmKtG9vEf9b0yOs1idS4UBVe4qFrurvs0f1nze5~6PiCWDMFJfoiZ~zmMYlAKEe2T3nJWGRB6UM6IbtyEfKtkZhYh4cGCGkhtcHfj1zcsfW7b4hyAKs9otUR0E9aeSYHMKoEu8SJlzDsN6y-MCYUMiySmZCDokCGRFQDQtJnWnqcHsAOcmZmcMrZ~AFUawab9i8BJtzu4W4p0plFV~iYN5lvEIa0xV2OA0VOe74OBxLlOoK-QoBM3En9rKAXLxDYfuPycVED44ZVX463eqQ__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
            "Jl. Indramayu",
            "11:00 WIB - 22:00 WIB",
            "Semua Umur",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce aliquam efficitur euismod. Vivamus scelerisque et urna scelerisque volutpat. Mauris volutpat varius eros, et condimentum leo varius et. Maecenas tincidunt ligula metus, porttitor condimentum neque interdum at. Morbi est nisi, pulvinar vel rutrum quis, dignissim nec libero. Suspendisse eget hendrerit orci. Pellentesque et vestibulum ex. Donec posuere lorem diam, volutpat imperdiet urna ornare nec. Nunc at tellus eros.\n" +
                    "Duis viverra ornare rutrum. Suspendisse sagittis, sem sed sagittis pretium, odio ante tempor dui, vel porta mauris leo non libero. Praesent aliquam maximus sem nec auctor. Morbi eget euismod ante, non dapibus diam. Nullam posuere consequat orci, et eleifend neque tempus vitae. Curabitur vitae congue lacus, a consequat mi. Suspendisse sapien diam, faucibus eget condimentum et, porta a felis.\n" +
                    "Phasellus sem risus, faucibus sed tellus ac, iaculis aliquet velit. Suspendisse potenti. Vivamus tincidunt ipsum vitae turpis tristique auctor. Pellentesque bibendum vestibulum nulla at finibus. Pellentesque euismod mauris felis, vitae molestie neque sollicitudin et. Sed at urna vulputate, faucibus augue id, malesuada felis. Donec sed pulvinar diam. Sed ante felis, ultrices vel posuere tristique, convallis sit amet urna. Pellentesque non accumsan lectus, vitae placerat metus."
        ),
        arrayOf(
            "Sampel Wisata Desa 4",
            "https://s3-alpha-sig.figma.com/img/a01a/a5f6/d4416ab8e72dbe7ba616f3a6dddbec73?Expires=1703462400&Signature=gqdvnyJuECFqr89Cs-B4MHIT1ctPI65-mKz3DMybGUwF~vi27Km6D~TKeqLhFjRBdBPR82Umy5UfnfI4laps-MbHbJId0CY9xP6kfYgRGtUm2qXvTivu0UrC2X0JMPlPNLzTVfovpqgniz8r83Zmw1KYqd9Qwy7XTJp87W~uzA74Gyg8o6YOWS1V5iTJDUaQfBvGr4L0IJm64FxHbk6HYkoQCVY-ZrfEHqSWuKByqoNqOzuIWJVD-yrhdE~dzvD-x0p4D734L7n1LbxL-R3xGY7uyMsRfGIwQgW6sYkOsS~Z8ZOX5wtgEKj2pC1jVxw~RtBDRotMcGYYMgpQEGYwdQ__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
            "Jl. Indramayu",
            "11:00 WIB - 22:00 WIB",
            "Semua Umur",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce aliquam efficitur euismod. Vivamus scelerisque et urna scelerisque volutpat. Mauris volutpat varius eros, et condimentum leo varius et. Maecenas tincidunt ligula metus, porttitor condimentum neque interdum at. Morbi est nisi, pulvinar vel rutrum quis, dignissim nec libero. Suspendisse eget hendrerit orci. Pellentesque et vestibulum ex. Donec posuere lorem diam, volutpat imperdiet urna ornare nec. Nunc at tellus eros.\n" +
                    "Duis viverra ornare rutrum. Suspendisse sagittis, sem sed sagittis pretium, odio ante tempor dui, vel porta mauris leo non libero. Praesent aliquam maximus sem nec auctor. Morbi eget euismod ante, non dapibus diam. Nullam posuere consequat orci, et eleifend neque tempus vitae. Curabitur vitae congue lacus, a consequat mi. Suspendisse sapien diam, faucibus eget condimentum et, porta a felis.\n" +
                    "Phasellus sem risus, faucibus sed tellus ac, iaculis aliquet velit. Suspendisse potenti. Vivamus tincidunt ipsum vitae turpis tristique auctor. Pellentesque bibendum vestibulum nulla at finibus. Pellentesque euismod mauris felis, vitae molestie neque sollicitudin et. Sed at urna vulputate, faucibus augue id, malesuada felis. Donec sed pulvinar diam. Sed ante felis, ultrices vel posuere tristique, convallis sit amet urna. Pellentesque non accumsan lectus, vitae placerat metus."
        ),
        arrayOf(
            "Sampel Wisata Desa 5",
            "https://s3-alpha-sig.figma.com/img/4376/7eaf/a5389ea429341e4348de8ff6ef23b870?Expires=1703462400&Signature=cUE1jr9lZMmu0YUDeE9jZqkyf7SIpFez7vpRIF3aRD~qcjv3LlMBryabkr78OXJWd6NzyEIvyIu9iPqHPz7Xt7o5HIllr90mQZOtTyFeqZrc3J-SqpSx3JXKAGV9tUC4OQGIxGxcHGMC51qa4N6vOTxIzlllEWyTuOqcqXvUcBD2sKMMIu1yWcOO21KBw9741wuzZWfJlrWf4nmrlW9-oeCHEpL7yYxYalbInWXbNms7jlnMm-nTo0THRazCGCU5dNmkeRMwZBw-Sr9SmpBXZkPsfnbUgz7InZ7PcP0LkW6Z0IFu6G8GNiYbcfrG3tjVsZQlxw~mvVabYwQj1dbQnA__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
            "Jl. Indramayu",
            "11:00 WIB - 22:00 WIB",
            "Semua Umur",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce aliquam efficitur euismod. Vivamus scelerisque et urna scelerisque volutpat. Mauris volutpat varius eros, et condimentum leo varius et. Maecenas tincidunt ligula metus, porttitor condimentum neque interdum at. Morbi est nisi, pulvinar vel rutrum quis, dignissim nec libero. Suspendisse eget hendrerit orci. Pellentesque et vestibulum ex. Donec posuere lorem diam, volutpat imperdiet urna ornare nec. Nunc at tellus eros.\n" +
                    "Duis viverra ornare rutrum. Suspendisse sagittis, sem sed sagittis pretium, odio ante tempor dui, vel porta mauris leo non libero. Praesent aliquam maximus sem nec auctor. Morbi eget euismod ante, non dapibus diam. Nullam posuere consequat orci, et eleifend neque tempus vitae. Curabitur vitae congue lacus, a consequat mi. Suspendisse sapien diam, faucibus eget condimentum et, porta a felis.\n" +
                    "Phasellus sem risus, faucibus sed tellus ac, iaculis aliquet velit. Suspendisse potenti. Vivamus tincidunt ipsum vitae turpis tristique auctor. Pellentesque bibendum vestibulum nulla at finibus. Pellentesque euismod mauris felis, vitae molestie neque sollicitudin et. Sed at urna vulputate, faucibus augue id, malesuada felis. Donec sed pulvinar diam. Sed ante felis, ultrices vel posuere tristique, convallis sit amet urna. Pellentesque non accumsan lectus, vitae placerat metus."
        ),
    )

//    val listData : ArrayList<Wisata>get() {
//        val list = ArrayList<Wisata>()
//        for (d in data) {
//            val dataDetail = Wisata()
//            dataDetail.title = d[0]
//            dataDetail.image = d[1]
//            dataDetail.lokasi = d[2]
//            dataDetail.time = d[3]
//            dataDetail.age = d[4]
//            dataDetail.desc = d[5]
//
//            list.add(dataDetail)
//        }
//        return list
//    }

    fun getWisataList(): ArrayList<Wisata> {
        val tempList = arrayListOf<Wisata>()
        for (i in data) {
            Log.e("jumlah data Wisata", i.toString())
            val wisata = Wisata(
                title = i[0],
                image = i[1],
                lokasi = i[2],
                time = i[3],
                age = i[4],
                desc = i[5]
            )
            tempList.add(wisata)
        }
        return tempList
    }
}