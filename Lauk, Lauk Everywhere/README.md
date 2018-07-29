###### <h1 align="center">Lauk, Lauk Everywhere</h1>

Restoran yang menyediakan terlalu sedikit pilihan hidangan biasanya membuat pelanggan cepat bosan. Namun, restoran yang menyediakan terlalu banyak pilihan hidangan malah membuat pelanggan bingung. Untuk mengantisipasi hal ini, Kriif, seorang pengelola restoran ternama di Kota Compfest, mencoba menghitung banyaknya kombinasi pemilihan hidangan yang mungkin di restoran barunya. Agar lebih praktis, ia meminta bantuan Anda.

Kriif akan memberikan Anda daftar menu di restoran barunya. Daftar menu tersebut terdiri dari satu-atau-lebih kelompok hidangan. Setiap hidangan yang tersedia di restoran baru Kriif dikelompokkan ke dalam satu-atau-lebih kelompok hidangan yang ada. Tidak mungkin ada dua-atau-lebih nama hidangan yang sama dalam setiap kelompok hidangan dan tidak mungkin ada kelompok hidangan yang tidak memiliki hidangan.

Setelah Anda memahami daftar menu tersebut, Kriif akan mengajukan beberapa pertanyaan. Ia akan menyebutkan nama-nama kelompok hidangan yang ada dalam daftar menu tersebut. Anda perlu menghitung banyaknya kombinasi pemilihan hidangan yang mungkin apabila pelanggan memilih tepat satu hidangan dari setiap kelompok hidangan yang ia disebutkan. Untuk mempermudah Anda, kombinasi yang melibatkan nama hidangan yang sama dalam kategori-kategori hidangan yang berbeda dianggap sebagai kombinasi yang berbeda.

## Format Masukan:

The first line is the number of test cases T. Each test case will have two numbers N and M, each on their own line given in that order. Following that is N lines of M characters that represent the map.

## Format Keluaran:

Untuk setiap pertanyaan, keluarkan sebuah bilangan yang menyatakan banyaknya kombinasi pemilihan hidangan yang mungkin.

See the sample output below for details.

## Keterangan:

Jawaban dijamin muat dalam tipe data bilangan bulat 64-bit (int64 pada Pascal; long long pada C/C++; long pada Java).

## Contoh Masukan 1:
```
# menu utama
nasi uduk
nasi liwet
nasi goreng
soto ayam
soto ayam spesial
soto babat
# lauk
ayam goreng
ikan bakar
# sayur
cah kangkung
sop
# minuman
es teh manis
soda susu
air putih
!
menu utama + lauk
minuman + menu utama
minuman
menu utama + lauk + sayur
```
## Contoh Keluaran 1:
```
12
18
3
24
```
## Contoh Masukan 2:
```
# paket a
nasi uduk
nasi campur
# paket b
nasi uduk
nasi campur
# paket c
nasi uduk
nasi goreng
!
paket a + paket b
paket a + paket b + paket c
```
## Contoh Keluaran 2:
```
4
8
```