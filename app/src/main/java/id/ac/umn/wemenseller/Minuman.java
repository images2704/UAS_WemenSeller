package id.ac.umn.wemenseller;

public class Minuman {
    private String namaMinuman;
    String hargaMinuman;
    private int imgMinuman;

    public Minuman(String namaMinuman, String hargaMinuman, int imgMinuman) {
        this.namaMinuman = namaMinuman;
        this.hargaMinuman = hargaMinuman;
        this.imgMinuman = imgMinuman;
    }

    public String getNamaMinuman() {
        return namaMinuman;
    }

    public void setNamaMinuman(String namaMinuman) {
        this.namaMinuman = namaMinuman;
    }

    public String getHargaMinuman() {
        return hargaMinuman;
    }

    public void setHargaMinuman(String hargaMinuman) {
        this.hargaMinuman = hargaMinuman;
    }

    public int getImgMinuman() {
        return imgMinuman;
    }

    public void setImgMinuman(int imgMinuman) {
        this.imgMinuman = imgMinuman;
    }
}
