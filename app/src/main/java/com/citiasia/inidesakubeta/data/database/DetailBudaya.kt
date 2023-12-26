package com.citiasia.inidesakubeta.data.database

import android.util.Log
import com.citiasia.inidesakubeta.data.remote.dummyObject.Tvcc
import com.citiasia.inidesakubeta.data.remote.model.ResponseTvcc

object DetailBudaya {
    private val data = arrayOf(
        arrayOf(
            "Sampel Budaya Desa 1",
            "https://s3-alpha-sig.figma.com/img/2422/14d1/81c595a7059398378a9dce21ce0df035?Expires=1703462400&Signature=YrHPg3az7Qv9OfVYQUhx-ChbaDHD5954rAj8B99hOcm-Ot97U2WedCyGzYkluM3h4thcygoQW7suzvgJhCorgYD-ECRj-VcJite2QvZbnyf2akS5-ECXban0o0zhi2cuJZ8zbkXZ3Svev4XgbF-VsA0e6cdoAwmBiRRCVFST4wgDD-PZ3riSRhCx8X6kTdVKQVNoW2qG2B4Vqpo3D3kh~n~Syg11MpiEefDxDDTWvXe1nIvLRs5G35VGnTAznNxHJJR6~xXshYRc6PPwDXHzLNg7RTsHYlOwV3~rClOmTtXvLqOruaj3lwKUeY0yUTQr9Uql1dmeMeTZmz~YGkpP5w__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
            "Admin 1",
            "11-11-2023",
            "11",
            "Sampel Galeri Budaya",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce aliquam efficitur euismod. Vivamus scelerisque et urna scelerisque volutpat. Mauris volutpat varius eros, et condimentum leo varius et. Maecenas tincidunt ligula metus, porttitor condimentum neque interdum at. Morbi est nisi, pulvinar vel rutrum quis, dignissim nec libero. Suspendisse eget hendrerit orci. Pellentesque et vestibulum ex. Donec posuere lorem diam, volutpat imperdiet urna ornare nec. Nunc at tellus eros.\n" +
                    "Duis viverra ornare rutrum. Suspendisse sagittis, sem sed sagittis pretium, odio ante tempor dui, vel porta mauris leo non libero. Praesent aliquam maximus sem nec auctor. Morbi eget euismod ante, non dapibus diam. Nullam posuere consequat orci, et eleifend neque tempus vitae. Curabitur vitae congue lacus, a consequat mi. Suspendisse sapien diam, faucibus eget condimentum et, porta a felis.\n" +
                    "Phasellus sem risus, faucibus sed tellus ac, iaculis aliquet velit. Suspendisse potenti. Vivamus tincidunt ipsum vitae turpis tristique auctor. Pellentesque bibendum vestibulum nulla at finibus. Pellentesque euismod mauris felis, vitae molestie neque sollicitudin et. Sed at urna vulputate, faucibus augue id, malesuada felis. Donec sed pulvinar diam. Sed ante felis, ultrices vel posuere tristique, convallis sit amet urna. Pellentesque non accumsan lectus, vitae placerat metus."
        ),
        arrayOf(
            "Sampel Budaya Desa 2",
            "https://s3-alpha-sig.figma.com/img/db72/0bf6/995a22b4eea604da09d680a5ffdf59f9?Expires=1703462400&Signature=TtPHrqJ8kN0rgXTu42vgBP-WSp6ZjOQcFOns8aw5Xjnyu7HS8MAJZCS-RGDu~JjMo8ElFpuY7cSSE4gk3U2mzdhfUYtzsJkoIvQinC~fPKbyv0Hyd7AvBebQDyc5CNP15bhOCaqRy1S3zmD~lH6EKYQbRlyOwSuBoMxinCcq0Rt72xfRkYp8keOPmfCnAszUNldQKyYxhljXVookXj417xEXfp8bRYmVypYNu-eiudskKuiemi~6UnlICdgGq-~cmDnR~SW7Nj2R0ld~DzHMrWMDxPHG1~W9hGEM65tvHCdKTVKj1xeyx8EjhJeoPHQ-LvQ3h0p5C3q0~1aJ2Ko2Aw__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
            "Admin 2",
            "11-11-2023",
            "11",
            "Sampel Galeri Budaya",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce aliquam efficitur euismod. Vivamus scelerisque et urna scelerisque volutpat. Mauris volutpat varius eros, et condimentum leo varius et. Maecenas tincidunt ligula metus, porttitor condimentum neque interdum at. Morbi est nisi, pulvinar vel rutrum quis, dignissim nec libero. Suspendisse eget hendrerit orci. Pellentesque et vestibulum ex. Donec posuere lorem diam, volutpat imperdiet urna ornare nec. Nunc at tellus eros.\n" +
                    "Duis viverra ornare rutrum. Suspendisse sagittis, sem sed sagittis pretium, odio ante tempor dui, vel porta mauris leo non libero. Praesent aliquam maximus sem nec auctor. Morbi eget euismod ante, non dapibus diam. Nullam posuere consequat orci, et eleifend neque tempus vitae. Curabitur vitae congue lacus, a consequat mi. Suspendisse sapien diam, faucibus eget condimentum et, porta a felis.\n" +
                    "Phasellus sem risus, faucibus sed tellus ac, iaculis aliquet velit. Suspendisse potenti. Vivamus tincidunt ipsum vitae turpis tristique auctor. Pellentesque bibendum vestibulum nulla at finibus. Pellentesque euismod mauris felis, vitae molestie neque sollicitudin et. Sed at urna vulputate, faucibus augue id, malesuada felis. Donec sed pulvinar diam. Sed ante felis, ultrices vel posuere tristique, convallis sit amet urna. Pellentesque non accumsan lectus, vitae placerat metus."
        ),
        arrayOf(
            "Sampel Budaya Desa 3",
            "https://s3-alpha-sig.figma.com/img/4b6e/500c/542ea6e5a064e16a4ac9e51668059c62?Expires=1703462400&Signature=haXrjCJ5BrU5q0pEuz8csApSvbiGjQ6h8rdS-FkhSivQ-pXdg~khpc8GIT-0E~kGf79qIAjrlIOZpmWuGyZQ~NOC9Aid1OiQMUEJ3qRGuI4OVQwoCkd8PTgIYWdf7U7xGUsE7Y~0lOEhFLoN-WbcI-XbJXcq4EGzGfxb8wgrspKALsumAnaYiwfhxX3DZXlPfehRFiirhw75V7uQdZ4GhfWA1CzAydQzZjkmxj1FxgFygJzhuqDNmH5tI4-p8OiYxSiQaY-2LzDiH5o5U6iq4ZA2ZKt9rKJpQQniUvJVm23Hedk~avlvpdq5HyW32d6A8mcHZc4Qxd~~knHQVNE1dg__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
            "Admin 3",
            "11-11-2023",
            "11",
            "Sampel Galeri Budaya",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce aliquam efficitur euismod. Vivamus scelerisque et urna scelerisque volutpat. Mauris volutpat varius eros, et condimentum leo varius et. Maecenas tincidunt ligula metus, porttitor condimentum neque interdum at. Morbi est nisi, pulvinar vel rutrum quis, dignissim nec libero. Suspendisse eget hendrerit orci. Pellentesque et vestibulum ex. Donec posuere lorem diam, volutpat imperdiet urna ornare nec. Nunc at tellus eros.\n" +
                    "Duis viverra ornare rutrum. Suspendisse sagittis, sem sed sagittis pretium, odio ante tempor dui, vel porta mauris leo non libero. Praesent aliquam maximus sem nec auctor. Morbi eget euismod ante, non dapibus diam. Nullam posuere consequat orci, et eleifend neque tempus vitae. Curabitur vitae congue lacus, a consequat mi. Suspendisse sapien diam, faucibus eget condimentum et, porta a felis.\n" +
                    "Phasellus sem risus, faucibus sed tellus ac, iaculis aliquet velit. Suspendisse potenti. Vivamus tincidunt ipsum vitae turpis tristique auctor. Pellentesque bibendum vestibulum nulla at finibus. Pellentesque euismod mauris felis, vitae molestie neque sollicitudin et. Sed at urna vulputate, faucibus augue id, malesuada felis. Donec sed pulvinar diam. Sed ante felis, ultrices vel posuere tristique, convallis sit amet urna. Pellentesque non accumsan lectus, vitae placerat metus."
        ),
        arrayOf(
            "Sampel Budaya Desa 4",
            "https://s3-alpha-sig.figma.com/img/f315/c485/2c8fd805fd941b7d7846f30332eaf721?Expires=1703462400&Signature=UOuf89msRZs3qJuVsU3XCESi0RytwycAeTWqRF72WmVOL1lWOBXQBTp7HYgnJTbmcGCXoCp8sn1XuNFYYCxBQXc92w8XGLgGJ7XGtKq4~nXwfMie9XwSzaiubrLw67sS7HIES3kopOhCTuVtkN4EoXZIlPMvH~M0PyrGz2uD9EeLdp3eNu-j0gBffO8j6gUDnYkD6Eadt7IGZp7jqKAm92TV7crxgMbl67EYI1Gd1WRkUsq7mb9izNWPZCNIemMzK16RX3zDKyN1~Wu2nEkGK2X0vMNPcujFn5PqMj0wME445pb7O~GLoE~j2QZjdHo-IvIkzmtZd063ZfUGQZRARQ__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
            "Admin 4",
            "11-11-2023",
            "11",
            "Sampel Galeri Budaya",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce aliquam efficitur euismod. Vivamus scelerisque et urna scelerisque volutpat. Mauris volutpat varius eros, et condimentum leo varius et. Maecenas tincidunt ligula metus, porttitor condimentum neque interdum at. Morbi est nisi, pulvinar vel rutrum quis, dignissim nec libero. Suspendisse eget hendrerit orci. Pellentesque et vestibulum ex. Donec posuere lorem diam, volutpat imperdiet urna ornare nec. Nunc at tellus eros.\n" +
                    "Duis viverra ornare rutrum. Suspendisse sagittis, sem sed sagittis pretium, odio ante tempor dui, vel porta mauris leo non libero. Praesent aliquam maximus sem nec auctor. Morbi eget euismod ante, non dapibus diam. Nullam posuere consequat orci, et eleifend neque tempus vitae. Curabitur vitae congue lacus, a consequat mi. Suspendisse sapien diam, faucibus eget condimentum et, porta a felis.\n" +
                    "Phasellus sem risus, faucibus sed tellus ac, iaculis aliquet velit. Suspendisse potenti. Vivamus tincidunt ipsum vitae turpis tristique auctor. Pellentesque bibendum vestibulum nulla at finibus. Pellentesque euismod mauris felis, vitae molestie neque sollicitudin et. Sed at urna vulputate, faucibus augue id, malesuada felis. Donec sed pulvinar diam. Sed ante felis, ultrices vel posuere tristique, convallis sit amet urna. Pellentesque non accumsan lectus, vitae placerat metus."
        ),
        arrayOf(
            "Sampel Budaya Desa 5",
            "https://s3-alpha-sig.figma.com/img/4ee5/846c/f67ba4af5321e7474a069d69c5f25769?Expires=1703462400&Signature=mEbf1Gn-E434rjhvXMwQENPBR2aQk5zwuOGMEpancwCFnR0MkZdrK6UYopiSjaOfEjni2WPlaHEUXatdbiA0VG2NJjOYisCRwchaYpgD0BbkZG768YQ4VJFaosnD4sT6g83e~v-MdSdRBOpIgllhfpQMmx1uk~7IBFTfbU5gRwlrZWK~tp2M~AkM6v~q9y16ZzDDhSDMbyzclbgomRrtOW6eXUi18lkiXVAjaLGHrY7FCVkjTZK~e3R-NIf8~x23sf9y6Qinxg-L1GvJhdn~blSWcTpr9CvWZlBDvO0rx91PacP1Q~BqCN7M5knYL~qoJ8NNZanqtJKG5xX6WuLHxQ__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
            "Admin 5",
            "11-11-2023",
            "11",
            "Sampel Galeri Budaya",
            "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce aliquam efficitur euismod. Vivamus scelerisque et urna scelerisque volutpat. Mauris volutpat varius eros, et condimentum leo varius et. Maecenas tincidunt ligula metus, porttitor condimentum neque interdum at. Morbi est nisi, pulvinar vel rutrum quis, dignissim nec libero. Suspendisse eget hendrerit orci. Pellentesque et vestibulum ex. Donec posuere lorem diam, volutpat imperdiet urna ornare nec. Nunc at tellus eros.\n" +
                    "Duis viverra ornare rutrum. Suspendisse sagittis, sem sed sagittis pretium, odio ante tempor dui, vel porta mauris leo non libero. Praesent aliquam maximus sem nec auctor. Morbi eget euismod ante, non dapibus diam. Nullam posuere consequat orci, et eleifend neque tempus vitae. Curabitur vitae congue lacus, a consequat mi. Suspendisse sapien diam, faucibus eget condimentum et, porta a felis.\n" +
                    "Phasellus sem risus, faucibus sed tellus ac, iaculis aliquet velit. Suspendisse potenti. Vivamus tincidunt ipsum vitae turpis tristique auctor. Pellentesque bibendum vestibulum nulla at finibus. Pellentesque euismod mauris felis, vitae molestie neque sollicitudin et. Sed at urna vulputate, faucibus augue id, malesuada felis. Donec sed pulvinar diam. Sed ante felis, ultrices vel posuere tristique, convallis sit amet urna. Pellentesque non accumsan lectus, vitae placerat metus."
        ),
    )

//    val listData : ArrayList<Budaya>get() {
//        val list = ArrayList<Budaya>()
//        for (d in data) {
//            val dataDetail = Budaya()
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

    fun getBudayaList(): ArrayList<Budaya> {
        val tempList = arrayListOf<Budaya>()
        for (i in data) {
            Log.e("jumlah data Budaya", i.toString())
            val budaya = Budaya(
                title = i[0],
                image = i[1],
                admin = i[2],
                time = i[3],
                viewer = i[4],
                galeri = i[5],
                desc = i[6]
            )
            tempList.add(budaya)
        }
        return tempList
    }
}

object GaleriBudaya {
    val pic = arrayListOf (
        "https://s3-alpha-sig.figma.com/img/25a3/e665/44db6d73cbe162f07133d06d50c76700?Expires=1704067200&Signature=cF7MvHGPVmjRnbcMsrBrI02dqJcy8Y44gh1H6aldflc~fy~y3xcJuZp-0PP0WaTDFDd6nmzjdv3925Oh3yFO4DsO7sWb-QVnCmJbdKiSL5dAFnjXTxZOGcybeVL1vt7Q8jzTDQ-t~uqjr5PRGqdcImER0jmb8q4NWFRiijnoPHBaElXHDbLupsw6IJqoSjbbwNg8DMsMUEy5Q2Awhyr4K2O-PoZ7lvW5AWtXFYq-47u-6gNlBYbhCp0ppZTry1E4wOK-iImBfXEUXd0rbT2mrLdL-d4twa-Pbj9nCqILrPhOi64i2NEbOpU6eMkba4KAwg5dXpzkMkbGa6CVtKNdpg__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
        "https://s3-alpha-sig.figma.com/img/37e3/0778/54fa40a5fb38578b9b54e9eb49f1a2f6?Expires=1704067200&Signature=SOUC~BUDR2mT2F4pSJubedJ3dS-L2a~vdwhiEtLboBXRz3J5WY~yJQPBUqpuLNlr6ilSoM0YKpj-cmN5~aP9qqE-GRjNxkKVTTi~1H-0apnqn7K6fdUCtcVsWTWYMCgCyYpus-jpecVR~Kbnw8vIfs6PKI73yjtlw25bPdLuCU53M6erGzlAXP3JFv4oM2VRE9QUk71CXu1NX7G1udcmQAYGs3EO1xG3mJZ9wUhsCZtuHDGAa-AlfDYG4~EnXJWn-m1PAcVrfPRdqVbFa8lpm6tlEwHxN~6xZNyrX6onw7MhRmaGPK7uJ2QNmh5SwIHStx~dnTkrhGMf6G2jlgviFg__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
        "https://s3-alpha-sig.figma.com/img/b05c/9ef1/b0033f8e7f7b79e414ecde6baf4278a4?Expires=1704067200&Signature=NOXrxgOr5nxqloKS0k~JXcKfcboYb-sC91IPdVz~nTYJQUT~sR6F-RMHh2236Wr9Rt5-jWi68w6p8Lcos1bPA-lX3Pi9D3O0v6NxbBHidoh1Cmr7NyEAWACW~E6Wl17ewtlwHEZpGWjf9vPMBIEYyPYDmO4yZDbdlroUl30U6bCVCS0gYqDmphahoYWdNry9pDiCn0tzc-3IpwI-VbmoZgoY8afSjyyoDrHhZGkh4ayyD89p-tZBGXT4CuOV1iif7aGUGYmiPldvgegVYsOPBH3bu3sf9dWap6g7bFF0miFhxKdfPHzVkdmBiGKydUeit-Xb358~8hbCv0XRpaVd5Q__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
        "https://s3-alpha-sig.figma.com/img/ca56/f796/29f9641f54048cbab78cba9e62483ead?Expires=1704067200&Signature=SukBeezIaNd5udTD~5t4Je43nxU3w5WTl0jxgieygUtbFmFrTGtSoCbxFgOYVvbvBtZp4H29CtNqZMddOS-3eclOnAIk2khW8ihMzBLbNsIf5zoJLMEWp4bTxBO4LkZrui0MN9VFb~CpONIvoZlw2EPUS1~Uqlz~~z-pvaZuqovzmd9b6uDzfZuSBv4AfVML0mbyMz79jhCT-lRp3hOO3Zyd~FyKl3n-W4lN98ldCQ7FmqDghAno8xtXTXzh8wmF3hgiSZUQ3j0DH3e88-N2BBTAQntL0Gv0iC3YQKrT10IaHWVhVbt~gJ3waxCgj~Y128S1sIpumy5LityQJR61Bg__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
        "https://s3-alpha-sig.figma.com/img/ca56/f796/29f9641f54048cbab78cba9e62483ead?Expires=1704067200&Signature=SukBeezIaNd5udTD~5t4Je43nxU3w5WTl0jxgieygUtbFmFrTGtSoCbxFgOYVvbvBtZp4H29CtNqZMddOS-3eclOnAIk2khW8ihMzBLbNsIf5zoJLMEWp4bTxBO4LkZrui0MN9VFb~CpONIvoZlw2EPUS1~Uqlz~~z-pvaZuqovzmd9b6uDzfZuSBv4AfVML0mbyMz79jhCT-lRp3hOO3Zyd~FyKl3n-W4lN98ldCQ7FmqDghAno8xtXTXzh8wmF3hgiSZUQ3j0DH3e88-N2BBTAQntL0Gv0iC3YQKrT10IaHWVhVbt~gJ3waxCgj~Y128S1sIpumy5LityQJR61Bg__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
        "https://s3-alpha-sig.figma.com/img/b05c/9ef1/b0033f8e7f7b79e414ecde6baf4278a4?Expires=1704067200&Signature=NOXrxgOr5nxqloKS0k~JXcKfcboYb-sC91IPdVz~nTYJQUT~sR6F-RMHh2236Wr9Rt5-jWi68w6p8Lcos1bPA-lX3Pi9D3O0v6NxbBHidoh1Cmr7NyEAWACW~E6Wl17ewtlwHEZpGWjf9vPMBIEYyPYDmO4yZDbdlroUl30U6bCVCS0gYqDmphahoYWdNry9pDiCn0tzc-3IpwI-VbmoZgoY8afSjyyoDrHhZGkh4ayyD89p-tZBGXT4CuOV1iif7aGUGYmiPldvgegVYsOPBH3bu3sf9dWap6g7bFF0miFhxKdfPHzVkdmBiGKydUeit-Xb358~8hbCv0XRpaVd5Q__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
        "https://s3-alpha-sig.figma.com/img/37e3/0778/54fa40a5fb38578b9b54e9eb49f1a2f6?Expires=1704067200&Signature=SOUC~BUDR2mT2F4pSJubedJ3dS-L2a~vdwhiEtLboBXRz3J5WY~yJQPBUqpuLNlr6ilSoM0YKpj-cmN5~aP9qqE-GRjNxkKVTTi~1H-0apnqn7K6fdUCtcVsWTWYMCgCyYpus-jpecVR~Kbnw8vIfs6PKI73yjtlw25bPdLuCU53M6erGzlAXP3JFv4oM2VRE9QUk71CXu1NX7G1udcmQAYGs3EO1xG3mJZ9wUhsCZtuHDGAa-AlfDYG4~EnXJWn-m1PAcVrfPRdqVbFa8lpm6tlEwHxN~6xZNyrX6onw7MhRmaGPK7uJ2QNmh5SwIHStx~dnTkrhGMf6G2jlgviFg__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
        "https://s3-alpha-sig.figma.com/img/25a3/e665/44db6d73cbe162f07133d06d50c76700?Expires=1704067200&Signature=cF7MvHGPVmjRnbcMsrBrI02dqJcy8Y44gh1H6aldflc~fy~y3xcJuZp-0PP0WaTDFDd6nmzjdv3925Oh3yFO4DsO7sWb-QVnCmJbdKiSL5dAFnjXTxZOGcybeVL1vt7Q8jzTDQ-t~uqjr5PRGqdcImER0jmb8q4NWFRiijnoPHBaElXHDbLupsw6IJqoSjbbwNg8DMsMUEy5Q2Awhyr4K2O-PoZ7lvW5AWtXFYq-47u-6gNlBYbhCp0ppZTry1E4wOK-iImBfXEUXd0rbT2mrLdL-d4twa-Pbj9nCqILrPhOi64i2NEbOpU6eMkba4KAwg5dXpzkMkbGa6CVtKNdpg__&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4",
    )

    fun getPicList(): ArrayList<PicBudaya> {
        val tempList = arrayListOf<PicBudaya>()
        for (i in pic.indices) {
            Log.e("jumlah data picture", i.toString())
            val picture = PicBudaya(
                pic = this.pic[i]
            )
            tempList.add(picture)
        }
        return tempList
    }
}