# LAPORAN PROJECT ULANGAN AKHIR SEMESTER PBO 

# Latar Belakang
Program studi Sistem Informasi adalah salah satu program studi yang terdapat dalam Universitas Islam Negri Surabaya. Sesuai kebiasaan dan budaya sejak lama, program studi ini mewajibkan mahasiswa-mahasiswa nya untuk menyumbangkan buku atau skripsi sebagai tanda pengabdian mereka. Namun, seringkali beberapa buku memiliki judul yang sama. Untuk itu, dibutuhkan sebuah manajemen system yang dapat membantu mengelola buku-buku tersebut. Sehingga, saya membuat sebuah system aplikasi yang mendukung tata Kelola buku dan skripsi yang ada dalam program studi ini. Dalam aplikasi ini, user dapat melakukan pencatatan, pengelolaan peminjaman, dan memungkinkan untuk mengelola buku-buku tersebut secara efisien dan terkoordinir.  Dengan cara ini juga, user dapat mencegah penumpukan buku dengan judul yang sama dan pemanfaatan yang lebih mudah dan baik.

# 1.2	TUJUAN DAN MANFAAT
A.	Berdasarkan latar belakang adapun tujuan dari pembuatan sebuah project ini, antara lain:
1)	Dapat membuat aplikasi yang memcahkan masalah penumpukan buku.
2)	Dapat menampilkan aplikasi pengelolaan buku pada neatbeans dengan menggunakan basis desktop.
3)	Dapat membuat tampilan mulai dari menu, tabel, dan input data.
4)	Dapat memahami, membuat dan menerapkan persistence, jasperReport, dan database dalam sebuah alur aplikasi yang dibuat sebelumnya.
B.	Adapun manfaat yang dapat diambil dari pembuatan sebuah project kali ini, anatara lain sebagai berikut:
1)	Menambah dan mengekspor pengetahuan tentang pembuatan aplikasi pengeloalaan buku dalam neatbeans.
2)	Menunjang penilain Ujian Akhir Semester pada semester ini.
3)	Meningatkan skill dan soft skill dalam dunia IT.
4)	Meningkatkan ketrampilan dan pengetahuan mahasiswa menjadi tenaga professional dalam menangani klien.

# 1.3	GAMBARAN SINGKAT APLIKASI
Dalam aplikasi pengeloalaan buku ini (Gloria) user dapat mengelola penyimpanan dan peminjaman buku. User dapat memanfaatkan fitur-fitur menu pada aplikasi dalam melakukan input data, update data, delete data, dan laporan dari data berdasarkan yang diinginakan user. Aplikasi ini, dapat membantu untuk mengelola buku-buku dan skripsi dengan baik dan mudah. 

# 2.1	Pengertian Postgree-SQL 

PostgreSQL adalah sistem manajemen database relasional (RDBMS) yang bersifat open source. Manajemen database ini dapat mengolah data dalam tabel yang memiliki relasi satu sama lain dan dapat digunakan secara gratis serta bebas dimodifikasi. Sistem manajemen database ini memiliki performa stabil, keamanan tinggi, serta fitur melimpah. PostgreSQL adalah database yang banyak digunakan pada web app, aplikasi mobile, dan aplikasi analytics. System ini juga mendukung beberapa bahasa pemrograman, salah satunya JAVA.
Sebagai database relasional, fungsi utama PostgreSQL adalah tempat untuk menyimpan dan mengelola data melalui perintah atau query SQL. Dalam database pada umumnya, system ini dapat melakukan DDL (create, drop, alter), DML (insert, update, delete), dan Controlling Data. 

# 2.2	Pengertian Netbeans
NetBeans adalah sebuah Integrated Development Environment (IDE) yang digunakan untuk mengembangkan perangkat lunak dengan berbagai bahasa pemrograman seperti Java, C/C++, dan PHP. IDE ini dikembangkan oleh Apache Software Foundation dan merupakan salah satu IDE yang populer di kalangan pengembang perangkat lunak.

NetBeans menyediakan berbagai fitur dan alat yang memudahkan pengembangan perangkat lunak, termasuk editor kode yang cerdas dengan fitur autocompletion, debugging, refactoring, dan manajemen proyek yang terintegrasi. IDE ini juga mendukung pengembangan aplikasi web dengan dukungan HTML, CSS, dan JavaScript.

Salah satu keunggulan NetBeans adalah kemampuannya untuk mengembangkan aplikasi Java secara komprehensif. IDE ini menyediakan alat bantu untuk membangun aplikasi desktop, aplikasi web, dan aplikasi mobile dengan menggunakan teknologi Java seperti JavaFX dan platform Android.

NetBeans tersedia secara gratis dan bersifat open-source, yang berarti pengembang dapat menggunakan dan memodifikasinya sesuai kebutuhan mereka. IDE ini juga memiliki komunitas yang aktif, yang memungkinkan pengguna untuk mendapatkan dukungan dan berbagi pengetahuan dengan pengembang lainnya. Dalam penggunaan Netbeans ini, saya menggunakan Netbeans IDE 16 dengan memanfaatkan JDK 18 didalamnya.

# 2.4	Pengertian Persistence
JPA adalah sebuah framework dalam pemrograman java menggunakan pendekatan Obejct Relational Maping (ORM) untuk manage relational data menggunakan platform Java Standard Edition dan Java Enterprise Edition. JPA saat ini sudah dirilis versi 2.0 dan sudah dilengkapi dengan berbagai fitur yang semakin memudahkan programer untuk manipulasi data seperti CRUD (Create, Read, Update, Delete). Penggunaan JPA ini mirip dengan penggunaan JDBC. Namun, beberapa hal menjadi lebih sederhana dalam mengoperasikan system melalui JPA. Dalam JPA tidak perlu membuat query untuk manipulasi data. Untuk membuat aplikasi menggunakan JPA, kita harus membuat class entitas yang merupakan representas table dari database yang dibuat. Untuk selanjutnya proses manipulasi data harus mengacu pada class entitas ini. Class ini dapat dibuat sendiri atau bisa juga menggunakan fitur generate pada netbeans.


# 3.1	DATABASE
Membuat database sesuai dengan yang dibutuhkan klien. Dalam Project ini saya membuat sebuah database dengan nama Perpustakaan. Dalam database ini terdiri dari 5tabel yaitu: tabel anggota, tabel buku, tabel skripsi, tabel peminjaman buku, dan tabel peminjaman skripsi. 

 # 3.3	DDL (Data Definition Language)
 Data Definition Language adalah bahasa pemrograman yang ada di dalam komputer sehingga bisa dimanfaatkan guna membuat ataupun memodifikasi struktur pada suatu objek pada database yang paling utama untuk pembuatan skema. Dalam DDL terdapat beebrapa perintah query, yaitu Create, Alter, dan Drop. Dalam project kali ini, saya menggunakan DDL sebagai berikut

 # 3.4	DML (Data Manipulation Language)
 Data Manipulation Language merupakan sekumpulan perintah yang dipergunakan dalam pengelolaan database seperti menampilkan, menghapus, menambah, dan membuat baru. Adapun perintah utamanya yaitu SELECT, INSERT, DELETE, dan UPDATE. (PDM) yang akan digunakan dalam implementasi teknis basis data. Dalam project kali ini, dalam database, saya hanya menggunakan perintah insert untuk menyimpan data. Selebihnya, saya lakukan pada program yang sudah berjalan dalam netbeans.

 # PENGIMPLEMENTASIAN PROJECT UAS Project Perpustakaan
 •	Login
Pada tampilan awal saat project akan di run akan tampil menu untuk login ke sebuah sistem yang kami buat. Untuk bisa melakukan login user perlu melakukan input username dan admin, sesuai dengan data yang terdapat dalam database. Contohnya pada project ini user bisa menginputkan username =  ”halo” dan password = “123” untuk bisa login. Dalam project ini, user hanya dapat menambahkan pengkases baru dalam database secara langsung, karena project ini belum dilengkapi dengan fitur sign up
•	Dashboard
Apabila akses login telah berhasil user akan diarahkan menuju tampilan dashboard secara otomatis. Dalam menu dashboard user dapat memilih untuk mengakses menu yang terdapat didalamnya sesuai dengan kebutuhan user, dalam mengaplikasikan program ini.
 
•	Book
Dalam menu Book user dapat memilih beberapa perintah, terdapat tombol ADD untuk menambah atau melakukan manipulasi data. Dan juga terdapat tombol PRINT untuk mencetak informasi pada book. Juga terdapat kolom pencarian untuk melakukan pencarian buku sesuai denga napa yang terdapat dalam combobox, disebelahnya.
 

•	Add data buku
Ketika user memilih untuk melakukan manipulasi data, maka user dapat menggunakan tombol add, sehingga akan muncul fitur sebagai berikut:
 
1.	Simpan data
 
Ketika user melakukan simpan/save data, maka harus menginputkan seluruh field dalam table yang ada. Sehingga Ketika sukses melakukan simpan data, maka akan muncul peringatan sebagai berikut, yang menandakan data sudah tersimpan secara otomatis. 
2.	Update data
Dalam melakukan update data, maka harus melakukan select data pada table, sehingga data akan muncul dalam field nya masing-masing. Kemudian, ubah data sesuai dengan kebutuhan user. Dan klik tombol update, paabila Update data sukses, maka akan muncul peringatan update data berhasil, seperti gambar berikut:
 
 
3.	Delete data
Dalam melakukan delete data, maka user juga harus melakukan slelect data terlebih dahulu, lalu klik tombol delete, dan bila berahsil maka akan muncul peringatan delete data berhasil sebagai berikut:

4.	Import data
Dalam melakukan import data yang berupa csv dari penyimpanan desktop yang dipakai, maka haru melakukan klik tombol import, dan pilih file csv yang ada dlaam penyimpanan pada desktop.
 
•	Print tombol book
Dalam menjalankan tombol print dalam form book maka, akan langsung diarahkan menuju laporan buku, dalam bentuk jasper report.
 
Dalam melakukan print, user juga dapat melakukan print berdasarkan hasil pencarian dalam tabel buku, mulai dari pencarian judul, tahun, penenerbit, kategori dan juga pengarang. Dengan melakukan search pada kolom filed terlebih dahulu, lalu melakukan klik tombol print.
Contoh: pencarian + print berdasarkan judul
 


•	Skripsi
Apabila user emilih menu skripsi maka akan muncul tampilan untuk mengelola skripsi. Dalam menu juga terdapat tombol ADD dan PRINT yang kegunaannya sama seperti form Book. 
 

•	Add data skripsi
User dapat melakukan simpan, update, delete, dan import data.
1.	Simpan data
 
2.	Update data
 
3.	Delete data
 
•	Print skripsi
Dalam mengakses tombol print, maka user akan langsung ditampilkan laporan dalam bentuk jasper report. 
 
Dalam melakukan print, user juga dapat melakukan print berdasarkan hasil pencarian dalam tabel buku, mulai dari pencarian judul, tahun, penenerbit, kategori dan juga pengarang. Dengan melakukan search pada kolom filed terlebih dahulu, lalu melakukan klik tombol print.
Contoh: berdasarkan tahun +print:
 

•	Peminjaman
Dalam form peminjaman, terdapat tabbed pane, antara peminjaman buku dan peminjaman skripsi. Sehingga user dapat memilih sesuai dengan kebutuhannya.
 
Dalam form peminjaman ini, user bisa melakukan perintah-perintah seperti dalam book form maupun skripsi form. 
•	Add data

 
Dalam melakukan save data, user dapat melakukan input idbuku yang merupakan foreign key, dengan memanfaatkan jDialog pada program.


BAB V
PENUTUP
5.1 Kesimpulan
Project ini melibatkan integrasi basis data untuk menyimpan dan mengelola informasi anggota, buku, skripsi, peminjaman buku, dan peminjaman skripsi. Dalam penggunaan basis data ini, yang digunakn untuk mengakses pada program yang dihubungakan dengan persistence dalam netbeans. Penggunaan Persistence dalam proyek ini memungkinkan aplikasi untuk terhubung dengan basis data, menjalankan pernyataan SQL, dan mengambil dan memanipulasi data. Project ini juga diharapkan dapat memenuhi tugas akhir mata kuliah PBO dalam semester kali ini.
5.2 Saran
Kepada mahasiswa ataupun orang IT diharapkan untuk selalu mengembangkan teknologi-teknologi kedepannya. Dan terkhusus untuk para mahasiswa bidang teknologi informasi untuk selalu mempelajari dan mencari pengetahuan baik dari luar maupun dalam universitas.





