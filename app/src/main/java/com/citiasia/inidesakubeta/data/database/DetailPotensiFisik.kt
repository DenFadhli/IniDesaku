package com.citiasia.inidesakubeta.data.database

import android.util.Log

object DetailPotensiFisik {
    private val data = arrayOf(
        arrayOf(
            "Sampel Potensi Fisik Desa 1",
            "https://s3-alpha-sig.figma.com/img/baa5/afef/9a5e051a3ee744f8dc2c850d28187187?Expires=1704672000&Signature=TDJEZ4vXTVVC2hu1gi~sicpYW8V0f-CNqVv-JtHEf-D4Jf38YLNojSL8~30Qp2M38GEVu6WzqLO2G3FUVNtpbHEX5pKPW66AMe1i1q2tWJA6v4H0CC-q6ehIvAhHo1Rkzrcc1-2hRVgH6dSgbiG6Bs9lokVIEbQireQCRjjh98WSN2bNX-bC7ynYoTlYfgvTMA0d3y-gpGKl~YnmFC5ZWJSKV5IbiNdhU1jksad-ZT~ePZ2tVX1mnD~jxLgEdyP2jhfL65LsoE7rE6eenrIJs7KV3zMmbbT4fIdjLz76mU1WynaGGvJS6gz-vHdVehAa7U0EGKSOzyXTJI7jaQhHsg__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
            "Admin 1",
            "11-11-2023",
            "11",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce aliquam efficitur euismod. Vivamus scelerisque et urna scelerisque volutpat. Mauris volutpat varius eros, et condimentum leo varius et. Maecenas tincidunt ligula metus, porttitor condimentum neque interdum at. Morbi est nisi, pulvinar vel rutrum quis, dignissim nec libero. Suspendisse eget hendrerit orci. Pellentesque et vestibulum ex. Donec posuere lorem diam, volutpat imperdiet urna ornare nec. Nunc at tellus eros.\n" +
                    "Duis viverra ornare rutrum. Suspendisse sagittis, sem sed sagittis pretium, odio ante tempor dui, vel porta mauris leo non libero. Praesent aliquam maximus sem nec auctor. Morbi eget euismod ante, non dapibus diam. Nullam posuere consequat orci, et eleifend neque tempus vitae. Curabitur vitae congue lacus, a consequat mi. Suspendisse sapien diam, faucibus eget condimentum et, porta a felis.\n" +
                    "Phasellus sem risus, faucibus sed tellus ac, iaculis aliquet velit. Suspendisse potenti. Vivamus tincidunt ipsum vitae turpis tristique auctor. Pellentesque bibendum vestibulum nulla at finibus. Pellentesque euismod mauris felis, vitae molestie neque sollicitudin et. Sed at urna vulputate, faucibus augue id, malesuada felis. Donec sed pulvinar diam. Sed ante felis, ultrices vel posuere tristique, convallis sit amet urna. Pellentesque non accumsan lectus, vitae placerat metus."
        ),
        arrayOf(
            "Sampel Potensi Fisik Desa 2",
            "https://s3-alpha-sig.figma.com/img/0b29/ae9c/786813c6014664a03b394d08b30d3ac4?Expires=1704672000&Signature=JjAil-e2~P820bQeXrm87-AoK22qsbEwKrzNLjWFYM9Jy4pTeN5uWWNrK1nguSu0CGlIZKJg1mJYWoqtJi0LYcWmfFPaTHxp8NF0Lt81~oVGXxV5CHfSSDBfQ4Z5-1XuT9pHnwr3JGbPOcTdCUkroZ6XipaGELAmI0DIfjxLmqzCHOVXFt4DkAmAmVAWvYHOV5GyLMs4-WthatIlysJ5QmJYucNcbKZqOGHfgVrUnFHXec4wSBvLRyckcQnDP5jAGr0BYICOUdRO9IwaeMvwyK9XQeU9VmCAUuwZSHfISD~BeHaqwfLgHrJU0Ehax-0apOveYNZ9YSqBZD9AW3nXUg__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
            "Admin 2",
            "11-11-2023",
            "11",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce aliquam efficitur euismod. Vivamus scelerisque et urna scelerisque volutpat. Mauris volutpat varius eros, et condimentum leo varius et. Maecenas tincidunt ligula metus, porttitor condimentum neque interdum at. Morbi est nisi, pulvinar vel rutrum quis, dignissim nec libero. Suspendisse eget hendrerit orci. Pellentesque et vestibulum ex. Donec posuere lorem diam, volutpat imperdiet urna ornare nec. Nunc at tellus eros.\n" +
                    "Duis viverra ornare rutrum. Suspendisse sagittis, sem sed sagittis pretium, odio ante tempor dui, vel porta mauris leo non libero. Praesent aliquam maximus sem nec auctor. Morbi eget euismod ante, non dapibus diam. Nullam posuere consequat orci, et eleifend neque tempus vitae. Curabitur vitae congue lacus, a consequat mi. Suspendisse sapien diam, faucibus eget condimentum et, porta a felis.\n" +
                    "Phasellus sem risus, faucibus sed tellus ac, iaculis aliquet velit. Suspendisse potenti. Vivamus tincidunt ipsum vitae turpis tristique auctor. Pellentesque bibendum vestibulum nulla at finibus. Pellentesque euismod mauris felis, vitae molestie neque sollicitudin et. Sed at urna vulputate, faucibus augue id, malesuada felis. Donec sed pulvinar diam. Sed ante felis, ultrices vel posuere tristique, convallis sit amet urna. Pellentesque non accumsan lectus, vitae placerat metus."
        ),
        arrayOf(
            "Sampel Potensi Fisik Desa 3",
            "https://s3-alpha-sig.figma.com/img/dcac/6d19/7d69e8d164dae73eb0627f18164b62cf?Expires=1704672000&Signature=jakjEIH-~bGm6BzGp9IHrDMyKpVxIxjBP1qPv5QkceGahKJ1NuQZBxsqJLZmmvGl9qPsmAGmpAIsVth9vNq7kchqB2R-yYiFU2O0X89ovdFQxV6bNA19wl1CFN-GzqpdI0Pa~8ECn4S9DiKbq0LMkqt7LSXDhtQ85WQXftKr07imaoYNZJDKPlbcACsrd4RNtnUuAFPk9RpU6Sf~lVuvEIYEXeaCc6AvdKxvepvB4LgOMhOvGyaqQZYbYSzeDBF7fbjrIToP5b-Mes~gU9kxW-gH-JuV3fDVTbyOfQ8MO12lxdc2ObVCuPQnIjFUpgRsvL5B-qjkiznVCtt5m-vqug__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
            "Admin 3",
            "11-11-2023",
            "11",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce aliquam efficitur euismod. Vivamus scelerisque et urna scelerisque volutpat. Mauris volutpat varius eros, et condimentum leo varius et. Maecenas tincidunt ligula metus, porttitor condimentum neque interdum at. Morbi est nisi, pulvinar vel rutrum quis, dignissim nec libero. Suspendisse eget hendrerit orci. Pellentesque et vestibulum ex. Donec posuere lorem diam, volutpat imperdiet urna ornare nec. Nunc at tellus eros.\n" +
                    "Duis viverra ornare rutrum. Suspendisse sagittis, sem sed sagittis pretium, odio ante tempor dui, vel porta mauris leo non libero. Praesent aliquam maximus sem nec auctor. Morbi eget euismod ante, non dapibus diam. Nullam posuere consequat orci, et eleifend neque tempus vitae. Curabitur vitae congue lacus, a consequat mi. Suspendisse sapien diam, faucibus eget condimentum et, porta a felis.\n" +
                    "Phasellus sem risus, faucibus sed tellus ac, iaculis aliquet velit. Suspendisse potenti. Vivamus tincidunt ipsum vitae turpis tristique auctor. Pellentesque bibendum vestibulum nulla at finibus. Pellentesque euismod mauris felis, vitae molestie neque sollicitudin et. Sed at urna vulputate, faucibus augue id, malesuada felis. Donec sed pulvinar diam. Sed ante felis, ultrices vel posuere tristique, convallis sit amet urna. Pellentesque non accumsan lectus, vitae placerat metus."
        ),
        arrayOf(
            "Sampel Potensi Fisik Desa 4",
            "https://s3-alpha-sig.figma.com/img/f315/c485/2c8fd805fd941b7d7846f30332eaf721?Expires=1703462400&Signature=UOuf89msRZs3qJuVsU3XCESi0RytwycAeTWqRF72WmVOL1lWOBXQBTp7HYgnJTbmcGCXoCp8sn1XuNFYYCxBQXc92w8XGLgGJ7XGtKq4~nXwfMie9XwSzaiubrLw67sS7HIES3kopOhCTuVtkN4EoXZIlPMvH~M0PyrGz2uD9EeLdp3eNu-j0gBffO8j6gUDnYkD6Eadt7IGZp7jqKAm92TV7crxgMbl67EYI1Gd1WRkUsq7mb9izNWPZCNIemMzK16RX3zDKyN1~Wu2nEkGK2X0vMNPcujFn5PqMj0wME445pb7O~GLoE~j2QZjdHo-IvIkzmtZd063ZfUGQZRARQ__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
            "Admin 4",
            "11-11-2023",
            "11",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce aliquam efficitur euismod. Vivamus scelerisque et urna scelerisque volutpat. Mauris volutpat varius eros, et condimentum leo varius et. Maecenas tincidunt ligula metus, porttitor condimentum neque interdum at. Morbi est nisi, pulvinar vel rutrum quis, dignissim nec libero. Suspendisse eget hendrerit orci. Pellentesque et vestibulum ex. Donec posuere lorem diam, volutpat imperdiet urna ornare nec. Nunc at tellus eros.\n" +
                    "Duis viverra ornare rutrum. Suspendisse sagittis, sem sed sagittis pretium, odio ante tempor dui, vel porta mauris leo non libero. Praesent aliquam maximus sem nec auctor. Morbi eget euismod ante, non dapibus diam. Nullam posuere consequat orci, et eleifend neque tempus vitae. Curabitur vitae congue lacus, a consequat mi. Suspendisse sapien diam, faucibus eget condimentum et, porta a felis.\n" +
                    "Phasellus sem risus, faucibus sed tellus ac, iaculis aliquet velit. Suspendisse potenti. Vivamus tincidunt ipsum vitae turpis tristique auctor. Pellentesque bibendum vestibulum nulla at finibus. Pellentesque euismod mauris felis, vitae molestie neque sollicitudin et. Sed at urna vulputate, faucibus augue id, malesuada felis. Donec sed pulvinar diam. Sed ante felis, ultrices vel posuere tristique, convallis sit amet urna. Pellentesque non accumsan lectus, vitae placerat metus."
        ),
        arrayOf(
            "Sampel Potensi Fisik Desa 5",
            "https://s3-alpha-sig.figma.com/img/f8b6/cf69/f81ed15c1327eddab260257f148ae995?Expires=1704672000&Signature=TpT514PWV52hdjp~S~0TqBa5EsP~xtmod-xxEs6ZuIggJLRhm7dVtoGe4o~z7QVbeO8Q0wvOXdvvyIrnZS2J-~gWHBcZnuKY0ZPueHhvVpLXdGbEYyikm-rn5aoISgzfkK9O4XiqgQ~aCwlM3C5Bojv2JtaJL~wc8jkxa9BJZdqC9pq0CemgwFqkTGkWIlJ9FCSoslLLd47z31CpV6NKosXAc1LTiiTqtrnFAlW2O-vwv7DySYkOMWA3ERb9y4H9GjGpvlN~q-FOZtJ15neX2XjcCD2ZI24ceWRoAPAFn1zmjnm72-pwMLgMlc~dKz6RPQg-9bbt7TdeKBglLu71pg__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
            "Admin 5",
            "11-11-2023",
            "11",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce aliquam efficitur euismod. Vivamus scelerisque et urna scelerisque volutpat. Mauris volutpat varius eros, et condimentum leo varius et. Maecenas tincidunt ligula metus, porttitor condimentum neque interdum at. Morbi est nisi, pulvinar vel rutrum quis, dignissim nec libero. Suspendisse eget hendrerit orci. Pellentesque et vestibulum ex. Donec posuere lorem diam, volutpat imperdiet urna ornare nec. Nunc at tellus eros.\n" +
                    "Duis viverra ornare rutrum. Suspendisse sagittis, sem sed sagittis pretium, odio ante tempor dui, vel porta mauris leo non libero. Praesent aliquam maximus sem nec auctor. Morbi eget euismod ante, non dapibus diam. Nullam posuere consequat orci, et eleifend neque tempus vitae. Curabitur vitae congue lacus, a consequat mi. Suspendisse sapien diam, faucibus eget condimentum et, porta a felis.\n" +
                    "Phasellus sem risus, faucibus sed tellus ac, iaculis aliquet velit. Suspendisse potenti. Vivamus tincidunt ipsum vitae turpis tristique auctor. Pellentesque bibendum vestibulum nulla at finibus. Pellentesque euismod mauris felis, vitae molestie neque sollicitudin et. Sed at urna vulputate, faucibus augue id, malesuada felis. Donec sed pulvinar diam. Sed ante felis, ultrices vel posuere tristique, convallis sit amet urna. Pellentesque non accumsan lectus, vitae placerat metus."
        ),
    )

//    val listData : ArrayList<PotensiFisik>get() {
//        val list = ArrayList<PotensiFisik>()
//        for (d in data) {
//            val dataDetail = PotensiFisik()
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

    fun getPotensiFisikList(): ArrayList<PotensiFisik> {
        val tempList = arrayListOf<PotensiFisik>()
        for (i in data) {
            Log.e("jumlah data Potensi Fisik", i.toString())
            val potensiFisik = PotensiFisik(
                title = i[0],
                image = i[1],
                admin = i[2],
                time = i[3],
                viewer = i[4],
                desc = i[5]
            )
            tempList.add(potensiFisik)
        }
        return tempList
    }
}