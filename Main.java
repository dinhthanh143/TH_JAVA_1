import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] mssv = new String[100];
        //Dữ liệu mẫu
        mssv[0] = "B1111111";
        mssv[1] = "B2222222";
        mssv[2] = "B3333333";
        //Regex
        String regex = "^B\\d{7}$";
        int curIndex = 3;
        int choice = -1;
        //Giao diện & Menu
        while (choice != 0) {
            System.out.println("\n=====Menu=====");
            System.out.println("1. In ra danh sach MSSV");
            System.out.println("2. Them moi MSSV");
            System.out.println("3. Cap nhat MSSV");
            System.out.println("4. Xoa MSSV");
            System.out.println("5. Tim kiem MSSV");
            System.out.println("0. Thoat chuong trinh");
            System.out.println("==============");
            System.out.println("Moi nhap lua chon: ");
            choice = sc.nextInt();
            switch (choice) {
                //In ra danh sách MSSV hiện có
                case 1: {
                    if (curIndex == 0) {
                        System.out.println("Chua co MSSV nao duoc luu.");
                    } else {
                        System.out.println("Danh sach mssv: \n");
                        for (int i = 0; i < curIndex; i++) {
                            System.out.printf("%s ", mssv[i]);
                        }
                    }
                    break;
                }
                //Chức năng Thêm mới
                case 2: {
                    boolean check = false;
                    while (check == false) {
                        System.out.println("Moi nhap MSSV muon them:");
                        String newId = sc.next();
                        //Validate Regex
                        if (newId.matches(regex)) {
                            System.out.println("Them thanh cong");
                            mssv[curIndex] = newId;
                            curIndex++;
                            break;
                        } else {
                            System.out.println("MSSV khong hop le");
                        }
                    }
                    break;
                }
                //Chức năng cập nhật
                case 3: {
                    System.out.println("Moi nhap index can sua: ");
                    int pos = sc.nextInt();
                    if (pos < 0 || pos > curIndex) {
                        System.out.println("Index khong hop le.");
                    } else {
                        boolean check = false;
                        while (check == false) {
                            System.out.println("Moi nhap MSSV muon sua:");
                            String newId = sc.next();
                            if (newId.matches(regex)) {
                                System.out.println("Sua thanh cong");
                                mssv[pos] = newId;
                                break;
                            } else {
                                System.out.println("MSSV khong hop le");
                            }
                        }

                    }
                    break;
                }
                //Chức năng Xóa (Dồn)
                case 4:{
                    System.out.println("Moi nhap index can xoa: ");
                    int pos = sc.nextInt();
                    if (pos < 0 || pos > curIndex) {
                        System.out.println("Index khong hop le.");
                    } else {
                        curIndex--;
                        for (int i = pos; i <= curIndex; i++) {
                            mssv[i] = mssv[i + 1];
                        }
                        System.out.println("Xoa thanh cong");
                    }
                    break;}
                //Tìm kiếm cơ bản
                case 5:{
                    sc.nextLine();
                    boolean found = false;
                    System.out.println("Moi nhap mot chuoi bat ki de tim kiem");
                    String val = sc.nextLine().toLowerCase();
                    for (int i = 0; i < curIndex; i++) {
                        if (mssv[i].toLowerCase().contains(val)) {
                            System.out.printf("%s ", mssv[i]);
                            found = true;
                        }
                    }
                    if (!found) System.out.println("Khong tim thay MSSV nao.");
                    break;}
                //Thoát chương trình
                case 0:
                    System.out.println("Thoat chuong trinh thanh cong");
                    break;
                default:
                    System.out.println("Lua chon khong hop le!");
                    break;
            }


        }
    }
}





