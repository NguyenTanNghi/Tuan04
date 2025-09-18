package edu.iuh.fit.bai03.entities;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class DanhMuc {
    private String maDM;
    private String tenDanhMuc;
    private String nguoiQuanLy;
    private String ghiChu;
}
