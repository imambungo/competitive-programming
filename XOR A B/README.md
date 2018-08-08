###### <h1 align="center">XOR A B</h1>
<center>Time limit: 1 s</center>
<center>Memory limit: 32 MB</center>

<br/>
Setelah beberapa kali gagal mengikuti ujian saringan masuk beberapa perguruan tinggi negeri unggulan, Pak Chanek akhirnya bekerja sebagai seorang lighting technician di suatu konser musik. Tugas yang dikerjakan Pak Chanek cukup sederhana, yaitu mengatur konfigurasi saklar-saklar lampu agar sesuai dengan petunjuk yang diberikan oleh manajernya.
<br/>
<br/>
Sayangnya, karena keterbatasan waktu, manajer Pak Chanek tidak dapat memberitahukan dengan terperinci saklar-saklar lampu mana saja yang harus dihidupkan. Ia hanya memberikan dua buah bilangan bulat A dan B di secarik kertas dan mengatakan bahwa konfigurasi saklar-saklar lampu yang benar dapat diketahui dengan menghitung nilai biner dari hasil operasi A⊕(A+1)⊕(A+2)⊕…⊕B. (Simbol ⊕ menyatakan operasi bitwise XOR.)
<br/>
<br/>
Ketidaktersediaan kertas dan alat tulis di lapangan membuat Pak Chanek bingung bukan kepalang. Ia tidak dapat membuat penghitungan di tempat kerjanya! Untuk memperburuk keadaan, konser akan dimulai beberapa menit lagi dan pengunjung sudah memadati lokasi konser. Di tengah keputusasaannya, Pak Chanek hanya dapat berharap kepada Anda, programmer andal yang sedang membaca soal ini di layar komputer, untuk membantunya. Bantulah Pak Chanek menyelesaikan tugasnya!

### Format Masukan

Masukan terdiri atas satu baris yang berisi dua buah bilangan bulat A dan B, dipisahkan oleh spasi.

### Format Keluaran

Keluaran berupa sebuah bilangan biner sesuai dengan deskripsi soal, tanpa leading zero.

### Batasan
Terdapat tiga subsoal pada soal ini. Untuk setiap subsoal berlaku

- 0 ≤ A ≤ B ≤ 2<sup>64</sup> − 1

<b>Subsoal 1 (30 poin)</b>

- B − A ≤ 1000000

<b>Subsoal 2 (30 poin)</b>

- A = 1

<b>Subsoal 3 (40 poin)</b>

- Tidak ada batasan tambahan.

### Contoh Masukan
```
2 10
```
### Contoh Keluaran
```
1010
```