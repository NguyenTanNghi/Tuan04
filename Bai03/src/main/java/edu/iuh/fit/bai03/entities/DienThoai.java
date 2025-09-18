package edu.iuh.fit.bai03.entities;


import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class DienThoai {
    private String maDT;
    private String tenDT;
    private int namSanXuat;
    private String cauHinh;
    private String maNCC;
    private String hinhAnh;
}
