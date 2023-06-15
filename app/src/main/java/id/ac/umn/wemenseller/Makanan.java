package id.ac.umn.wemenseller;

public class Makanan {
    private String namaMakanan;
    String hargaMakanan;
    private int imgMakanan;

    public Makanan(String namaMakanan, String hargaMakanan, int imgMakanan) {
        this.namaMakanan = namaMakanan;
        this.hargaMakanan = hargaMakanan;
        this.imgMakanan = imgMakanan;
    }

    public String getNamaMakanan() {
        return namaMakanan;
    }

    public void setNamaMakanan(String namaMakanan) {
        this.namaMakanan = namaMakanan;
    }

    public String getHargaMakanan() {
        return hargaMakanan;
    }

    public void setHargaMakanan(String hargaMakanan) {
        this.hargaMakanan = hargaMakanan;
    }

    public int getImgMakanan() {
        return imgMakanan;
    }

    public void setImgMakanan(int imgMakanan) {
        this.imgMakanan = imgMakanan;
    }
}
