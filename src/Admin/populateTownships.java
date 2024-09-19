
package Admin;

import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
import javax.swing.JComboBox;

public class populateTownships {

  private JComboBox<String> comboBox1; // Dropdown for townships
  private JComboBox<String> comboBox2; // Dropdown for NRC regions

  public populateTownships(JComboBox<String> comboBox1, JComboBox<String> comboBox2) {
    this.comboBox1 = comboBox1;
    this.comboBox2 = comboBox2;
    populateTownships(this.comboBox1, this.comboBox2);
  }

  private void populateTownships(JComboBox<String> comboBox1, JComboBox<String> comboBox2) {
    HashMap<String, List<String>> townshipMap = new HashMap<>();

    // Adding townships for region "1/"
    townshipMap.put("1/",
        Arrays.asList("BaMaNa", "KhaHpaNa", "DaHpaYa", "HaPaNa", "HpaKaNa", "AhGaYa", "KaMaNa", "KaMaTa",
            "KaPaTa", "MaKhaBa", "MaSaNa", "MaKaTa", "MaNyaNa", "KhaLaHpa", "LaGaNa", "MaMaNa", "MaKaNa",
            "MaLaNa", "NaMaNa", "PaWaNa", "PaNaDa", "PaTaAh", "SaDaNa", "YaBaYa", "SaBaNa", "SaPaYa",
            "TaNaNa", "SaLaNa", "TaSaLa", "WaMaNa"));

    // Adding townships for region "2/"
    townshipMap.put("2/",
        Arrays.asList("BaLaKha", "DaMaSa", "HpaSaNa", "HpaYaSa", "LaKaNa", "MaSaNa", "YaTaNa", "aThaNa"));

    // Adding townships for region "3/"
    townshipMap.put("3/",
        Arrays.asList("BaGaLa", "LaBaNa", "BaAhNa", "HpaPaNa", "BaThaSa", "KaMaMa", "KaKaYa", "KaDaNa",
            "KaSaKa", "KaDaTa", "LaThaNa", "MaWaTa", "PaKaNa", "YaYaTha", "SaKaLa", "ThaTaNa", "ThaTaKa",
            "WaLaMa"));

    // Adding townships for region "4/"
    townshipMap.put("4/", Arrays.asList("KaKhaNa", "HpaLaNa", "HaKhaNa", "KaPaLa", "MaTaPa", "MaTaNa", "PaLaWa",
        "YaZaNa", "YaKhaDa", "SaMaNa", "TaTaNa", "HtaTaLa", "TaZaNa"));

    // Adding townships for region "5/"
    townshipMap.put("5/",
        Arrays.asList("AhYaTa", "BaMaNa", "BaTaLa", "KhaTaNa", "KhaOuTa", "HaMaLa", "AhTaNa", "KaLaHta",
            "KaLaWa", "KaBaLa", "KaNaNa", "KaThaNa", "KaLaTa", "KhaOuNa", "KaLaNa", "LaHaNa", "LaYaNa",
            "MaLaNa", "MaKaNa", "MaYaNa", "MaMaNa", "MaMaTa", "NaYaNa", "NgaZaNa", "PaLaNa", "HpaPaNa",
            "PaLaBa", "SaKaNa", "SaLaKa", "YaBaNa", "DaPaYa", "TaMaNa", "TaSaNa", "HtaKhaNa", "WaLaNa",
            "WaThaNa", "YaOuNa", "YaMaPa", "KaMaNa", "KhaPaNa"));

    // Adding townships for region "6/"
    townshipMap.put("6/",
        Arrays.asList("BaPaNa", "HtaWaNa", "KaLaAh", "KaThaNa", "KaSaNa", "LaLaNa", "MaMaNa", "PaLaNa",
            "TaThaYa", "ThuYaKha", "YaHpaNa", "KhaMaNa", "MaTaNa", "PaLaTa", "MaAhYa", "MaAhYa", "KaYaYa"));

    // Adding townships for region "7/"
    townshipMap.put("7/",
        Arrays.asList("DaOuNa", "KaPaKa", "KaWaNa", "KaKaNa", "KaTaKha", "LaPaTa", "MaLaNa", "MaNyaNa",
            "NaTaLa", "NyaLaPa", "AhHpaNa", "AhTaNa", "PaTaNa", "PaKhaTa", "PaKhaNa", "PaTaTa", "PaNaKa",
            "HpaMaNa", "PaMaNa", "YaTaNa", "YaKaNa", "HtaTaPa", "TaNgaNa", "ThaNaPa", "ThaWaTa", "ThaKaNa",
            "ThaSaNa", "WaMaNa", "YaTaYa", "ZaKaNa", "PaTaSa"));

    // Adding townships for region "8/"
    townshipMap.put("8/",
        Arrays.asList("AhLaNa", "KhaMaNa", "GaGaNa", "KaMaNa", "MaKaNa", "MaBaNa", "MaTaNa", "MaLaNa", "MaMaNa",
            "MaHtaNa", "MaThaNa", "NaMaNa", "NgaHpaNa", "PaKhaKa", "PaMaNa", "PaHpaNa", "SaLaNa", "SaMaNa",
            "SaHpaNa", "SaTaYa", "SaPaWa", "TaTaKa", "ThaYaNa", "HtaLaNa", "YaNaKha", "YaSaKa", "MaHtaNa",
            "KaHtaNa", "MaTaNa"));


// Adding townships for region "9/"
    townshipMap.put("9/",
        Arrays.asList("AhMaYa", "AhMaZa", "KhaAhZa", "KhaMaSa", "KaPaTa", "KaSaNa", "MaTaYa", "MaHaMa",
            "MaLaNa", "MaYaMa", "MaYaTa", "MaNaMa", "MaNaTa", "MaHtaLa", "MaKaNa", "MaKhaNa", "MaThaNa",
            "NaHtaNa", "NaHtaKa", "NgaThaYa", "NgaZaNa", "NyaOuNa", "PaThaKa", "PaBaNa", "PaKaKha",
            "PaOuLa", "SaKaNa", "SaKaTa", "ThaPaKa", "TaTaOu", "TaThaNa", "ThaSaNa", "WaTaNa", "YaMaTha",
            "NgaThaYa", "TaKaNa", "TaKaTa", "MaMaNa", "DaKhaTha", "LaWaNa", "OuTaTha", "PaBaTha", "PaMaNa",
            "TaKaNa", "ZaBaTha", "ZaYaTha"));

    // Adding townships for region "10/"
    townshipMap.put("10/", Arrays.asList("BaLaNa", "KhaSaNa", "KhaZaNa", "KaMaYa", "KaHtaNa", "LaMaNa", "MaLaMa",
        "MaDaNa", "PaMaNa", "ThaHpaYa", "ThaHtaNa", "YaMaNa"));

    // Adding townships for region "11/"
    townshipMap.put("11/",
        Arrays.asList("AaMaNa", "BaThaTa", "GaMaNa", "KaHpaNa", "KaTaNa", "MaAhNa", "MaAhTa", "MaTaNa",
            "MaPaNa", "MaAhNa", "MaOuNa", "MaPaTa", "PaTaNa", "PaNaKa", "PaNaTa", "YaBaNa", "YaThaTa",
            "SaTaNa", "ThaTaNa", "TaKaNa", "KaTaLa", "TaPaWa"));

    // Adding townships for region "12/"
    townshipMap.put("12/",
        Arrays.asList("AhSaNa", "BaHaNa", "BaTaHta", "KaKaKa", "DaGaYa", "DaGaMa", "DaGaSa", "DaGaTa", "DaGaNa",
            "DaLaNa", "DaPaNa", "LaThaYa", "LaMaNa", "LaKaNa", "MaBaNa", "HtaTaPa", "AhSaNa", "KaMaYa",
            "KaMaNa", "KhaYaNa", "KaKhaKa", "KaTaTa", "KaTaNa", "KaMaTa", "LaMaTa", "LaThaNa", "MaYaKa",
            "MaGaDa", "MaGaTa", "OuKaMa", "PaBaTa", "PaZaTa", "SaKhaNa", "SaKaKha", "SaKaNa", "YaPaTha",
            "OuKaTa", "TaTaHta", "TaKaNa", "TaMaNa", "ThaKaTa", "ThaLaNa", "ThaGaKa", "ThaKhaNa", "TaTaNa",
            "YaKaNa", "OuKaNa"));

    // Adding townships for region "13/"
    townshipMap.put("13/",
        Arrays.asList("AhKhaNa", "KhaYaHa", "KhaMaNa", "HaTaNa", "HaPaNa", "HaPaTa", "SaHpaNa", "ThaNaNa",
            "SaSaNa", "ThaPaNa", "KaLaHpa", "KaLaNa", "KaLaDa", "KaMaSa", "KaTaNa", "KaYaNa", "KaTaTa",
            "KaHaNa", "KaLaNa", "KaLaTa", "KaKhaNa", "KaMaNa", "KaTaLa", "KaThaNa", "LaKhaNa", "LaKhaTa",
            "LaYaNa", "LaKaNa", "LaKaTa", "LaKhaNa", "LaHaNa", "LaLaNa", "LaHtaNa", "MaBaNa", "MaMaSa",
            "MaTaNa", "MaTaTa", "MaMaNa", "MaHpaNa", "MaKaNa", "MaPaNa", "MaHpaNa", "MaSaNa", "MaYaNa",
            "MaKhaNa", "MaLaNa", "MaMaNa", "MaMaTa", "MaMaNa", "MaMaTa", "MaNaNa", "MaPaNa", "MaPaNa",
            "MaTaNa", "MaYaTa", "MaYaNa", "MaYaNa", "MaSaTa", "NaKhaWa", "NaTaNa", "NaKhaTa", "NaKhaNa",
            "NaMaTa", "NaHpaNa", "NaSaNa", "NaSaNa", "NaKaNa", "NaWaNa", "NaPhaNa", "NaKhaNa", "NakhaTa",
            "NyaYaNa", "PaKhaNa", "PaYaNa", "PaSaNa", "PaWaNa", "HpaKhaNa", "PaTaYa", "PaLaNa", "TaKhaLa",
            "TaYaNa", "TaKhaNa", "YaLaNa", "YaSaNa", "YaHpaNa", "YaNgaNa", "NaTaYa", "PaLaTa", "KhaLaNa",
            "PaPaKa", "MaHaYa", "TaMaNya", "MaBaNa", "MaNgaNa", "AhTaNa", "TaLaNa"));

    // Adding townships for region "14/"
    townshipMap.put("14/",
        Arrays.asList("AhMaTa", "BaKaLa", "DaNaHpa", "DaDaYa", "AhMaNa", "HaKaKa", "HaThaTa", "AhGaPa",
            "KaKaHta", "KaLaNa", "KaKhaNa", "KaKaNa", "KaPaNa", "LaPaTa", "LaMaNa", "MaAhNa", "MaMaNa",
            "NgaPaTa", "NgaThaKha", "NgaYaKa", "NgaSaNa", "NgaThaYa", "NyaTaNa", "PaTaNa", "PaThaNa",
            "HpaPaNa", "PaSaLa", "YaThaYa", "ThaPaNa", "WaKhaMa", "YaKaNa", "ZaLaNa", "PaThaYa"));

    // Get the selected region from comboBox2 and update comboBox1
    comboBox1.removeAllItems();
    String selectedRegion = (String) comboBox2.getSelectedItem();
    List<String> townships = townshipMap.get(selectedRegion);
    if (townships != null) {
      for (String township : townships) {
        comboBox1.addItem(township);
      }
    }
  }
}