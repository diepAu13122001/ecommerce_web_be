package com.backend.ecommerceweb.enums;


public class Enums {
    public Enums() {
    }


    public static enum TypeMethod {
        PAYPAL("Paypal");

        String description;

        private TypeMethod(final String description) {
            this.description = description;
        }

        public String getDescription() {
            return this.description;
        }
    }

    public static enum TypeTransaction {
        DEPOSIT("Nạp tiền"),
        APPLY_CLASS("Đăng kí nhận lớp"),
        CREATE_CLASS("Tạo lớp"),
        BECOME_TUTOR("Trở thành gia sư");


        String description;

        private TypeTransaction(final String description) {
            this.description = description;
        }

        public String getDescription() {
            return this.description;
        }
    }

    public static enum TypeStatusTransaction {
        FAILED("Thất bại"),
        SUCCESS("Thành công");

        String description;
        private TypeStatusTransaction(final String description) {
            this.description = description;
        }

        public String getDescription() {
            return this.description;
        }
    }


    public static enum TypeAddress {
        USER("Khách hàng"),
        CLASS("Lớp học");

        String description;

        private TypeAddress(final String description) {
            this.description = description;
        }

        public String getDescription() {
            return this.description;
        }
    }

    public static enum Gender {
        MALE("Nam"),
        FEMALE("Nữ"),
        ALL("Tất cả");

        String description;

        private Gender(final String description) {
            this.description = description;
        }

        public String getDescription() {
            return this.description;
        }
    }


    public static enum LevelTutor {
        TEACHER("Giáo viên"),
        STUDENT("Sinh viên");

        String description;

        private LevelTutor(final String description) {
            this.description = description;
        }

        public String getDescription() {
            return this.description;
        }
    }

    public static enum StatusClassRoom {
        CREATE("Mới tạo"),
        TEACHING("Đang có người dạy"),
        WAIT_APPROVAL("Chờ duyệt"),
        COMPLETED("Thành công");

        String description;

        private StatusClassRoom(final String description) {
            this.description = description;
        }

        public String getDescription() {
            return this.description;
        }
    }
}
