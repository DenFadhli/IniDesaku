package com.citiasia.inidesakubeta.data.database

import android.util.Log
import com.citiasia.inidesakubeta.data.remote.dummyObject.Tvcc
import com.citiasia.inidesakubeta.data.remote.model.ResponseTvcc

object DetailBerita {
    private val data = arrayOf(
        arrayOf(
            "Sampel Berita Desa 1",
            "https://s3-alpha-sig.figma.com/img/7f59/024f/b7aeb934bdc941b731218f0b4db5a465?Expires=1703462400&Signature=C4Cqcu71ZHNcmQP53jo20EezLeWLFJUWKOMHkTPDtTjXqeqlA52HXo6qXxa2-mze4vGm63VVjvmAHzuZoQ~MGuwq34c69sGn7nwVRqDfWY5QEU4pMkLnKrNhKCb3vwrZHR8imd7EF-VjWs45L~ufKIKNvl9K1moP~XFJXLe63G39pCcZENvFl0zbS-nF06HVlVbxjYGkA4RQAj65y7RGWxmhEE1tnU5bMcZUdnAEukfZa4wo4f1mvWW45-UvA0giFeAxT9seIAwG5NH0aHqYA3CJUqlrhwjaevtFZLCbzkQM00siJaAZQjHj3PT0uyITKWboT-tCZwDwqbFmRjwSkA__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
            "Admin 1",
            "11-11-2023",
            "11",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce aliquam efficitur euismod. Vivamus scelerisque et urna scelerisque volutpat. Mauris volutpat varius eros, et condimentum leo varius et. Maecenas tincidunt ligula metus, porttitor condimentum neque interdum at. Morbi est nisi, pulvinar vel rutrum quis, dignissim nec libero. Suspendisse eget hendrerit orci. Pellentesque et vestibulum ex. Donec posuere lorem diam, volutpat imperdiet urna ornare nec. Nunc at tellus eros.\n" +
                    "Duis viverra ornare rutrum. Suspendisse sagittis, sem sed sagittis pretium, odio ante tempor dui, vel porta mauris leo non libero. Praesent aliquam maximus sem nec auctor. Morbi eget euismod ante, non dapibus diam. Nullam posuere consequat orci, et eleifend neque tempus vitae. Curabitur vitae congue lacus, a consequat mi. Suspendisse sapien diam, faucibus eget condimentum et, porta a felis.\n" +
                    "Phasellus sem risus, faucibus sed tellus ac, iaculis aliquet velit. Suspendisse potenti. Vivamus tincidunt ipsum vitae turpis tristique auctor. Pellentesque bibendum vestibulum nulla at finibus. Pellentesque euismod mauris felis, vitae molestie neque sollicitudin et. Sed at urna vulputate, faucibus augue id, malesuada felis. Donec sed pulvinar diam. Sed ante felis, ultrices vel posuere tristique, convallis sit amet urna. Pellentesque non accumsan lectus, vitae placerat metus."
        ),
        arrayOf(
            "Sampel Berita Desa 2",
            "https://s3-alpha-sig.figma.com/img/ed60/7430/6f55e5e889ff7d9b9269af034b2c29cb?Expires=1703462400&Signature=FQUfHEVu24RzLch1~9Jw1rnNPqjmVkEeQUYXgv9KoT4o1-KnO-xd8OszL4drsTNq1xD5rnIXSdqFkz~upQRYMl4ZFVs6QVVwcLJrwCxBdm0ky2HQJaUNvw069-ewo9dJLiyarv30Vf-q4udyDJhQY6PQ7tgG1DUe0tH5HHHVBAHY~moGaadqeWi~mvvLGIfOx5rLuAT70UxvUxSEzoIbEjX7yI3gV9k6GFibSPSpKBB10lw53GSvZYbGBwFiItUif57qVV7JpCX725iO7c0aMt9R8IwuIYgU8xDTiyspfSBoIiFeib5D1-npiF5~x1HeCg0KnAJ4PDtE0ssZuvZ38g__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
            "Admin 2",
            "11-11-2023",
            "11",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce aliquam efficitur euismod. Vivamus scelerisque et urna scelerisque volutpat. Mauris volutpat varius eros, et condimentum leo varius et. Maecenas tincidunt ligula metus, porttitor condimentum neque interdum at. Morbi est nisi, pulvinar vel rutrum quis, dignissim nec libero. Suspendisse eget hendrerit orci. Pellentesque et vestibulum ex. Donec posuere lorem diam, volutpat imperdiet urna ornare nec. Nunc at tellus eros.\n" +
                    "Duis viverra ornare rutrum. Suspendisse sagittis, sem sed sagittis pretium, odio ante tempor dui, vel porta mauris leo non libero. Praesent aliquam maximus sem nec auctor. Morbi eget euismod ante, non dapibus diam. Nullam posuere consequat orci, et eleifend neque tempus vitae. Curabitur vitae congue lacus, a consequat mi. Suspendisse sapien diam, faucibus eget condimentum et, porta a felis.\n" +
                    "Phasellus sem risus, faucibus sed tellus ac, iaculis aliquet velit. Suspendisse potenti. Vivamus tincidunt ipsum vitae turpis tristique auctor. Pellentesque bibendum vestibulum nulla at finibus. Pellentesque euismod mauris felis, vitae molestie neque sollicitudin et. Sed at urna vulputate, faucibus augue id, malesuada felis. Donec sed pulvinar diam. Sed ante felis, ultrices vel posuere tristique, convallis sit amet urna. Pellentesque non accumsan lectus, vitae placerat metus."
        ),
        arrayOf(
            "Sampel Berita Desa 3",
            "https://s3-alpha-sig.figma.com/img/1097/f19a/df26ef6d586e4e091b3ed0928488eae6?Expires=1703462400&Signature=cbsoco-ZRrw2urXk~88nf5xMRLyNrZQrIZFN4cdGFkKhw6ILrlcvko3R2tGsbGP1e9FpQMEfVNXpe3DiUV1V4uDK9bBDphcZrEGOsxvYRU7YigDoFZIuHOnPIj-mZHZ4pDsxEPdVcbF8aOpqaYq7CSJJKUL6MIqpn6B9H7xkZ7SXDgnP9nrWOXB3yf8sRCf0D72~3lUuMGBmqxORi6s3U1~5gl2OUWXU~NNlfflFn2H-ma6dCP3E-GjGYeIpneM9UiKw1nQ6XP1jAaLtdwXXTaC7~H8D99K7ijVCkeswyjJdFBV-S9fTE7v0kNKrHccAe6MGp~wHZ870f6G6rlMwlQ__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
            "Admin 3",
            "11-11-2023",
            "11",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce aliquam efficitur euismod. Vivamus scelerisque et urna scelerisque volutpat. Mauris volutpat varius eros, et condimentum leo varius et. Maecenas tincidunt ligula metus, porttitor condimentum neque interdum at. Morbi est nisi, pulvinar vel rutrum quis, dignissim nec libero. Suspendisse eget hendrerit orci. Pellentesque et vestibulum ex. Donec posuere lorem diam, volutpat imperdiet urna ornare nec. Nunc at tellus eros.\n" +
                    "Duis viverra ornare rutrum. Suspendisse sagittis, sem sed sagittis pretium, odio ante tempor dui, vel porta mauris leo non libero. Praesent aliquam maximus sem nec auctor. Morbi eget euismod ante, non dapibus diam. Nullam posuere consequat orci, et eleifend neque tempus vitae. Curabitur vitae congue lacus, a consequat mi. Suspendisse sapien diam, faucibus eget condimentum et, porta a felis.\n" +
                    "Phasellus sem risus, faucibus sed tellus ac, iaculis aliquet velit. Suspendisse potenti. Vivamus tincidunt ipsum vitae turpis tristique auctor. Pellentesque bibendum vestibulum nulla at finibus. Pellentesque euismod mauris felis, vitae molestie neque sollicitudin et. Sed at urna vulputate, faucibus augue id, malesuada felis. Donec sed pulvinar diam. Sed ante felis, ultrices vel posuere tristique, convallis sit amet urna. Pellentesque non accumsan lectus, vitae placerat metus."
        ),
        arrayOf(
            "Sampel Berita Desa 4",
            "https://s3-alpha-sig.figma.com/img/ed60/7430/6f55e5e889ff7d9b9269af034b2c29cb?Expires=1703462400&Signature=FQUfHEVu24RzLch1~9Jw1rnNPqjmVkEeQUYXgv9KoT4o1-KnO-xd8OszL4drsTNq1xD5rnIXSdqFkz~upQRYMl4ZFVs6QVVwcLJrwCxBdm0ky2HQJaUNvw069-ewo9dJLiyarv30Vf-q4udyDJhQY6PQ7tgG1DUe0tH5HHHVBAHY~moGaadqeWi~mvvLGIfOx5rLuAT70UxvUxSEzoIbEjX7yI3gV9k6GFibSPSpKBB10lw53GSvZYbGBwFiItUif57qVV7JpCX725iO7c0aMt9R8IwuIYgU8xDTiyspfSBoIiFeib5D1-npiF5~x1HeCg0KnAJ4PDtE0ssZuvZ38g__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
            "Admin 4",
            "11-11-2023",
            "11",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce aliquam efficitur euismod. Vivamus scelerisque et urna scelerisque volutpat. Mauris volutpat varius eros, et condimentum leo varius et. Maecenas tincidunt ligula metus, porttitor condimentum neque interdum at. Morbi est nisi, pulvinar vel rutrum quis, dignissim nec libero. Suspendisse eget hendrerit orci. Pellentesque et vestibulum ex. Donec posuere lorem diam, volutpat imperdiet urna ornare nec. Nunc at tellus eros.\n" +
                    "Duis viverra ornare rutrum. Suspendisse sagittis, sem sed sagittis pretium, odio ante tempor dui, vel porta mauris leo non libero. Praesent aliquam maximus sem nec auctor. Morbi eget euismod ante, non dapibus diam. Nullam posuere consequat orci, et eleifend neque tempus vitae. Curabitur vitae congue lacus, a consequat mi. Suspendisse sapien diam, faucibus eget condimentum et, porta a felis.\n" +
                    "Phasellus sem risus, faucibus sed tellus ac, iaculis aliquet velit. Suspendisse potenti. Vivamus tincidunt ipsum vitae turpis tristique auctor. Pellentesque bibendum vestibulum nulla at finibus. Pellentesque euismod mauris felis, vitae molestie neque sollicitudin et. Sed at urna vulputate, faucibus augue id, malesuada felis. Donec sed pulvinar diam. Sed ante felis, ultrices vel posuere tristique, convallis sit amet urna. Pellentesque non accumsan lectus, vitae placerat metus."
        ),
        arrayOf(
            "Sampel Berita Desa 5",
            "https://s3-alpha-sig.figma.com/img/7f59/024f/b7aeb934bdc941b731218f0b4db5a465?Expires=1703462400&Signature=C4Cqcu71ZHNcmQP53jo20EezLeWLFJUWKOMHkTPDtTjXqeqlA52HXo6qXxa2-mze4vGm63VVjvmAHzuZoQ~MGuwq34c69sGn7nwVRqDfWY5QEU4pMkLnKrNhKCb3vwrZHR8imd7EF-VjWs45L~ufKIKNvl9K1moP~XFJXLe63G39pCcZENvFl0zbS-nF06HVlVbxjYGkA4RQAj65y7RGWxmhEE1tnU5bMcZUdnAEukfZa4wo4f1mvWW45-UvA0giFeAxT9seIAwG5NH0aHqYA3CJUqlrhwjaevtFZLCbzkQM00siJaAZQjHj3PT0uyITKWboT-tCZwDwqbFmRjwSkA__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
            "Admin 5",
            "11-11-2023",
            "11",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce aliquam efficitur euismod. Vivamus scelerisque et urna scelerisque volutpat. Mauris volutpat varius eros, et condimentum leo varius et. Maecenas tincidunt ligula metus, porttitor condimentum neque interdum at. Morbi est nisi, pulvinar vel rutrum quis, dignissim nec libero. Suspendisse eget hendrerit orci. Pellentesque et vestibulum ex. Donec posuere lorem diam, volutpat imperdiet urna ornare nec. Nunc at tellus eros.\n" +
                    "Duis viverra ornare rutrum. Suspendisse sagittis, sem sed sagittis pretium, odio ante tempor dui, vel porta mauris leo non libero. Praesent aliquam maximus sem nec auctor. Morbi eget euismod ante, non dapibus diam. Nullam posuere consequat orci, et eleifend neque tempus vitae. Curabitur vitae congue lacus, a consequat mi. Suspendisse sapien diam, faucibus eget condimentum et, porta a felis.\n" +
                    "Phasellus sem risus, faucibus sed tellus ac, iaculis aliquet velit. Suspendisse potenti. Vivamus tincidunt ipsum vitae turpis tristique auctor. Pellentesque bibendum vestibulum nulla at finibus. Pellentesque euismod mauris felis, vitae molestie neque sollicitudin et. Sed at urna vulputate, faucibus augue id, malesuada felis. Donec sed pulvinar diam. Sed ante felis, ultrices vel posuere tristique, convallis sit amet urna. Pellentesque non accumsan lectus, vitae placerat metus."
        ),
    )

//    val listDataBerita : ArrayList<Berita>get() {
//        val list = ArrayList<Berita>()
//        for (d in data) {
//            val dataDetail = Berita()
//            dataDetail.title = d[0]
//            dataDetail.image = d[1]
//            dataDetail.admin = d[2]
//            dataDetail.time = d[3]
//            dataDetail.viewer = d[4]
//            dataDetail.desc = d[5]
//
//            list.add(dataDetail)
//        }
//        return list
//    }

    fun getBeritaList(): ArrayList<Berita> {
        val tempList = arrayListOf<Berita>()
        for (i in data) {
            Log.e("jumlah data Berita", i.toString())
            val berita = Berita(
                title = i[0],
                image = i[1],
                admin = i[2],
                time = i[3],
                viewer = i[4],
                desc = i[5]
            )
            tempList.add(berita)
        }
        return tempList
    }
}