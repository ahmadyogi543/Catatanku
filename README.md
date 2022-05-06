# Catatanku

## Deskripsi

Catatanku adalah aplikasi android yang digunakan untuk mengelola pencatatan penjualan sebuah toko yang awalnya hanya dituliskan pada buku catatan berbentuk fisik, diganti dengan menggunakan aplikasi android. Pada aplikasi ini, si pemilik toko dapat mendaftarkan barang-barang jualan dan informasi terkait barang-barang jualannya seperti harga per satuan, stok yang tersedia, dan lain-lain.

## Fitur

Berikut merupakan fitur-fitur yang terdapat pada aplikai Catatanku :

-   Menambahkan barang jualan
-   Mencatat informasi penjualan harian (barang apa saja yang dijual dan berapa banyaknya)
-   Melihat statistik dan laporan penjualan harian, minggguan, dan bulanan
-   Menambahkan catatan penting terkait penjualan barang
-   ...

## Arsitektur Aplikasi

Berikut adalah deskripsi terkait arsitektur dari aplikasi Catatanku :

-   Untuk basis data menggunakan Room Database (wrapper untuk SQLite).
-   Aplikasi Android dibangun menggunakan Android Native Java pada Android Studio.
-   Pertukaran data pada aplikasi hanya terjadi pada sistem dengan pengguna.
-   Aplikasi bersifat offline.
-   Aplikasi menerapkan arsitektur Single Activity App.
-   Password yang disimpan pada database telah dihashed menggunakan algoritma MD5.

### Arsitektur Basis Data

Class name: User
Attribute(s):

-   userName: String (PK)
-   fullName: String
-   storeName: String
-   password: String
-   passwordHint: String

Class name: Good
Attribute(s):

-   goodId: int (PK)
-   goodName: String
-   goodQty: int
-   goodQuality: String
-   goodPrice: int

Class name: Transaction
Attribute(s):

-   transactionId: int (PK)
-   transactionDate: Date
-   transactionItem(s): String(s)
-   transactionTotalPrice: int
-   ...

## Desain Aplikasi

Aplikasi Catatanku menerapkan desain _guideline_ dari Google, yakni Material Design agar pengguna merasa nyaman dan mudah dalam menggunakan aplikasi. Adapun tampilan antarmuka dari aplikasi adalah sebagai berikut :

-   _Splashscreen_
-   Halaman sign up
-   Halaman login
-   Halaman penjualan barang
-   Halaman catatan penjualan
-   Halaman statistik penjualan
-   Halaman daftar barang

## Status Pengembangan Aplikasi

-   [x] Mengimplementasi Bottom Navigation dengan menggunakan Navigation Component.
-   [x] Mengimplementasi semua tampilan pada tiap section untuk Bottom Navigation View.
-   [x] Mengimpelementasikan navigation component beserta alur aplikasi.
-   [x] Mengimplementasikan algoritma hashing MD5 untuk penyimpanan password.
-   [x] Mengimplementasikan Room Database.
-   [x] Mengimpelmentasikan Recycleview.
-   [x] Mengimplementasikan sistem login, signup.
-   [x] Halaman barang sudah bekerja dengan semestinya (dapat melakukan CRUD).
-   [ ] Halaman transaksi...
-   [ ] Halaman informasi...
