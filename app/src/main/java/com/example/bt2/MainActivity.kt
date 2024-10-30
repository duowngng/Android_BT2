package com.example.bt2

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    private lateinit var studentAdapter: StudentAdapter
    private lateinit var rvStudentList: RecyclerView
    private lateinit var etSearch: EditText
    private var studentList = listOf(
        Student("20214980", "Hoàng Tố An"),
        Student("20210065", "Hà Hoàng Kỳ Anh"),
        Student("20214987", "Phạm Nhật Anh"),
        Student("20214990", "Trịnh Việt Anh"),
        Student("20210093", "Hà Duy Bách"),
        Student("20210098", "Kha Minh Bảo"),
        Student("20215003", "Đào Sỹ Cường"),
        Student("20214998", "Phạm Mai Chi"),
        Student("20215007", "Nghiêm Xuân Diện"),
        Student("20215011", "Đặng Tiến Dũng"),
        Student("20215014", "Trần Đình Dũng"),
        Student("20210284", "Nguyễn Trọng Khánh Duy"),
        Student("20215023", "Nguyễn Gia Tùng Dương"),
        Student("20215028", "Nguyễn Thành Đạt"),
        Student("20210151", "Lường Hải Đăng"),
        Student("20210208", "Đàm Trần Ngọc Đức"),
        Student("20215038", "Phan Trung Đức"),
        Student("20215041", "Dương Văn Giới"),
        Student("20215046", "Chu Đình Hiển"),
        Student("20215050", "Nguyễn Mạnh Hiếu"),
        Student("20215054", "Lưu Việt Hoàn"),
        Student("20215056", "Nguyễn Huy Hoàng"),
        Student("20215063", "Phạm Tấn Hưng"),
        Student("20215067", "Dương Trung Kiên"),
        Student("20210494", "Trần Trung Kiên"),
        Student("20210463", "Trần An Khang"),
        Student("20215076", "Phạm Thành Lập"),
        Student("20215079", "Nguyễn Mạnh Linh"),
        Student("20215083", "Đinh Văn Luận"),
        Student("20210606", "Đoàn Quang Minh"),
        Student("20215091", "Nguyễn Hữu Minh"),
        Student("20215095", "Hà Đình Nam"),
        Student("20215099", "Phạm Hoàng Hải Nam"),
        Student("20215103", "Ngọ Doãn Ngọc"),
        Student("20215110", "Vũ Thị Quỳnh Như"),
        Student("20210670", "Hoàng Hải Phong"),
        Student("20215116", "Nguyễn Đức Phú"),
        Student("20215121", "Phạm Hiểu Phương"),
        Student("20215128", "Vũ Minh Quân"),
        Student("20210729", "Nguyễn Văn Quý"),
        Student("20215133", "Đoàn Minh Tài"),
        Student("20215157", "Lê Hoàng Anh Tuấn"),
        Student("20215161", "Lương Nguyễn Quốc Tùng"),
        Student("20210798", "Hoàng Kim Trí Thành"),
        Student("20215145", "Ngô Văn Thức"),
        Student("20215143", "Nguyễn Ngọc Anh Thư"),
        Student("20215150", "Bùi Thị Hương Trà"),
        Student("20215154", "Hoàng Quốc Trung"),
        Student("20215166", "Lê Quốc Việt"),
        Student("20215171", "Hoàng Nguyên Vũ")
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvStudentList = findViewById(R.id.rvStudentList)
        etSearch = findViewById(R.id.etSearch)

        studentAdapter = StudentAdapter(studentList)
        rvStudentList.layoutManager = LinearLayoutManager(this)
        rvStudentList.adapter = studentAdapter

        etSearch.addTextChangedListener(object : TextWatcher {
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                val query = s.toString()
                if (query.length > 2) {
                    val filteredList = studentList.filter {
                        it.fullName.contains(query, ignoreCase = true) || it.id.contains(query)
                    }
                    studentAdapter.updateList(filteredList)
                } else {
                    studentAdapter.updateList(studentList)
                }
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}
        })
    }
}
