
Silakan salin teks di bawah ini ke file `README.md` Anda:

---

```markdown
# Tugas Praktikum: CRUD Manajemen KTP
**Nama:** Choirul Amir Siregar  
**NIM:** 20230140249  
**Repositori:** Tugas_CRUD_20230140249

---

## 📝 Deskripsi Proyek
Aplikasi ini merupakan sistem manajemen data KTP berbasis web yang dibangun menggunakan arsitektur **Clean Architecture** pada Spring Boot. Aplikasi mendukung operasi CRUD (Create, Read, Update, Delete) secara penuh dengan antarmuka pengguna yang interaktif menggunakan AJAX (tanpa refresh halaman).

## 🛠️ Stack Teknologi
- **Backend:** Java 17, Spring Boot 3.4.x
- **Frontend:** HTML5, Bootstrap 5, jQuery 3.6 (AJAX)
- **Database:** MySQL 8.x
- **Build Tool:** Maven

## 📂 Struktur Package
* `model`: Kelas Entity untuk representasi tabel database.
* `dto`: Data Transfer Object untuk pertukaran data API.
* `repository`: Interface Spring Data JPA untuk akses database.
* `service`: Interface untuk logika bisnis.
* `service.impl`: Implementasi dari Service Layer.
* `controller`: REST API Endpoint.
* `mapper`: Komponen untuk konversi Entity ke DTO dan sebaliknya.
* `util`: Kelas bantuan (seperti Wrapper Response standar).

## ⚙️ Cara Menjalankan Program
1. **Konfigurasi Database:**
   Buat database bernama `spring` di MySQL dan sesuaikan `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/spring
   spring.datasource.username=root
   spring.datasource.password=your_password

```

2. **Jalankan Aplikasi:**
Jalankan file `TugasCrudNimApplication.java` dari IDE Anda (IntelliJ/VS Code).
3. **Akses Website:**
Buka browser dan arahkan ke: `http://localhost:8080`

---

## 📡 Dokumentasi API (Endpoints)

Semua response API dibungkus menggunakan kelas `WebResponse<T>` dengan format:
`{ "status": "...", "message": "...", "data": {...} }`

| Method | Endpoint | Fungsi |
| --- | --- | --- |
| **POST** | `/ktp` | Menambah data KTP baru |
| **GET** | `/ktp` | Mengambil seluruh daftar KTP |
| **GET** | `/ktp/{id}` | Mengambil detail KTP berdasarkan ID |
| **PUT** | `/ktp/{id}` | Memperbarui data KTP berdasarkan ID |
| **DELETE** | `/ktp/{id}` | Menghapus data KTP dari database |

### 🚀 Hasil Pengujian API

#### 1. Tambah Data KTP (`POST /ktp`)

**Request Body:**

```json
{
    "nomorKtp": "1234567900",
    "namaLengkap": "Budi Ahmado",
    "alamat": "Jl. Merdeka No. 10",
    "tanggalLahir": "1995-05-20",
    "jenisKelamin": "Laki-laki"
}

```

**Response Body:**

```json
{
    "message": "Data KTP berhasil ditambahkan!",
    "status": "success",
    "data": {
        "id": 6,
        "nomorKtp": "1234567900",
        "namaLengkap": "Budi Ahmado",
        "alamat": "Jl. Merdeka No. 10",
        "tanggalLahir": "1995-05-20",
        "jenisKelamin": "Laki-laki"
    }
}

```

#### 2. Update Data KTP (`PUT /ktp/{id}`)

**Request Body:**

```json
{
    "nomorKtp": "1234567901",
    "namaLengkap": "Budi Ahmado",
    "alamat": "Jl. Merdeka No. 10",
    "tanggalLahir": "1995-05-20",
    "jenisKelamin": "Laki-laki"
}

```

**Response Body:**

```json
{
    "message": "Data KTP berhasil diperbarui!",
    "status": "success",
    "data": {
        "id": 6,
        "nomorKtp": "1234567901",
        "namaLengkap": "Budi Ahmado",
        "alamat": "Jl. Merdeka No. 10",
        "tanggalLahir": "1995-05-20",
        "jenisKelamin": "Laki-laki"
    }
}

```

#### 3. Ambil Semua Data (`GET /ktp`)

**Response Body:**

```json
{
    "message": "Berhasil mengambil semua data KTP",
    "status": "success",
    "data": [
        {
            "id": 1,
            "nomorKtp": "1571070101050201",
            "namaLengkap": "Choirul Amir Siregar",
            "alamat": "Jl.Untung Suropati Rt.24",
            "tanggalLahir": "2005-01-01",
            "jenisKelamin": "Laki-laki"
        },
        {
            "id": 2,
            "nomorKtp": "1234567890",
            "namaLengkap": "Budi Santoso",
            "alamat": "Jl. Merdeka No. 10",
            "tanggalLahir": "1995-05-20",
            "jenisKelamin": "Laki-laki"
        },
        {
            "id": 5,
            "nomorKtp": "12345678",
            "namaLengkap": "amir",
            "alamat": "jalan jalan",
            "tanggalLahir": "2026-03-14",
            "jenisKelamin": "Laki-laki"
        }
    ]
}

```

#### 4. Hapus Data KTP (`DELETE /ktp/{id}`)

**Response Body:**

```json
{
    "message": "Data KTP dengan ID 6 berhasil dihapus",
    "status": "success",
    "data": null
}

```

---


1. Tampilan Utama (Daftar KTP)


2. Form Tambah & Validasi Error


3. Notifikasi Berhasil (Feedback)
---

© 2026 - Tugas Praktikum Pemrograman Server-side

```
