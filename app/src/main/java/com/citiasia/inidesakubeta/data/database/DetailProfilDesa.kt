package com.citiasia.inidesakubeta.data.database

object DetailProfilDesa {
    private val data = arrayOf(
        arrayOf(
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce aliquam efficitur euismod. Vivamus scelerisque et urna scelerisque volutpat. Mauris volutpat varius eros, et condimentum leo varius et. Maecenas tincidunt ligula metus, porttitor condimentum neque interdum at. Morbi est nisi, pulvinar vel rutrum quis, dignissim nec libero. Suspendisse eget hendrerit orci. Pellentesque et vestibulum ex. Donec posuere lorem diam, volutpat imperdiet urna ornare nec. Nunc at tellus eros.\n" +
                    "Duis viverra ornare rutrum. Suspendisse sagittis, sem sed sagittis pretium, odio ante tempor dui, vel porta mauris leo non libero. Praesent aliquam maximus sem nec auctor. Morbi eget euismod ante, non dapibus diam. Nullam posuere consequat orci, et eleifend neque tempus vitae. Curabitur vitae congue lacus, a consequat mi. Suspendisse sapien diam, faucibus eget condimentum et, porta a felis.\n" +
                    "Phasellus sem risus, faucibus sed tellus ac, iaculis aliquet velit. Suspendisse potenti. Vivamus tincidunt ipsum vitae turpis tristique auctor. Pellentesque bibendum vestibulum nulla at finibus. Pellentesque euismod mauris felis, vitae molestie neque sollicitudin et. Sed at urna vulputate, faucibus augue id, malesuada felis. Donec sed pulvinar diam. Sed ante felis, ultrices vel posuere tristique, convallis sit amet urna. Pellentesque non accumsan lectus, vitae placerat metus.",
            "Kode Wilayah 32.12.14.2005",
            "Desa Gelarmendala",
            "081234567890",
            "@DesaGelarmendala",
            "Desa.Gelarmendala"
        ),
    )

    val listData : ArrayList<ProfilDesa>get() {
        val list = ArrayList<ProfilDesa>()
        for (d in data) {
            val dataDetail = ProfilDesa()
            dataDetail.desc = d[0]
            dataDetail.code = d[1]
            dataDetail.village = d[2]
            dataDetail.number = d[3]
            dataDetail.mail = d[4]
            dataDetail.web = d[5]

            list.add(dataDetail)
        }
        return list
    }
}