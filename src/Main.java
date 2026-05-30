import com.pi4j.Pi4J;
import com.pi4j.context.Context;
import com.pi4j.io.gpio.digital.DigitalOutput;
import com.pi4j.io.gpio.digital.DigitalState;

public class Main {

    @SuppressWarnings("removal") // address() metodundaki deprecated uyarısını susturur
    public static void main() {
        // BCM Pinleri: 26, 19, 13, 6, 22, 27, 17
        int[] LED_PINS = {26, 19, 13, 6, 22, 27, 17};

        Context pi4j = null;
        System.out.println("V4.0.1 ile 7 LED sistemi başlatılıyor...");
        try {
            pi4j = Pi4J.newAutoContext();

            // Pini yapılandır ve oluştur
            var config1 = DigitalOutput.newConfigBuilder(pi4j)
                    .id("led_" + LED_PINS[0])
                    .name("LED Pin " + LED_PINS[0])
                    .address(LED_PINS[0])
                    .shutdown(DigitalState.LOW)// Uygulama kapanış güvenliği
                    .initial(DigitalState.LOW) // İlk açılış güvenliği
                    .build();

            DigitalOutput morKablo = pi4j.create(config1);
            //diğital output olarak yapılandırdığımız ( BCM 26 ) adresli pini high yapalım
            morKablo.high();
            // ------------------------------------------------------------------------------------------



            // Pini yapılandır ve oluştur
            var config2 = DigitalOutput.newConfigBuilder(pi4j)
                    .id("led_" + LED_PINS[1])
                    .name("LED Pin " + LED_PINS[1])
                    .address(LED_PINS[1])
                    .shutdown(DigitalState.LOW)// Uygulama kapanış güvenliği
                    .initial(DigitalState.LOW) // İlk açılış güvenliği
                    .build();

            DigitalOutput maviKablo = pi4j.create(config2);
            //diğital output olarak yapılandırdığımız ( BCM 19 ) adresli pini high yapalım
            maviKablo.high();
            // ------------------------------------------------------------------------------------------



            // Pini yapılandır ve oluştur
            var config3 = DigitalOutput.newConfigBuilder(pi4j)
                    .id("led_" + LED_PINS[2])
                    .name("LED Pin " + LED_PINS[2])
                    .address(LED_PINS[2])
                    .shutdown(DigitalState.LOW)// Uygulama kapanış güvenliği
                    .initial(DigitalState.LOW) // İlk açılış güvenliği
                    .build();

            DigitalOutput yesilKablo = pi4j.create(config3);
            //diğital output olarak yapılandırdığımız ( BCM 13 ) adresli pini high yapalım
            yesilKablo.high();
            // ------------------------------------------------------------------------------------------



            // Pini yapılandır ve oluştur
            var config4 = DigitalOutput.newConfigBuilder(pi4j)
                    .id("led_" + LED_PINS[3])
                    .name("LED Pin " + LED_PINS[3])
                    .address(LED_PINS[3])
                    .shutdown(DigitalState.LOW)// Uygulama kapanış güvenliği
                    .initial(DigitalState.LOW) // İlk açılış güvenliği
                    .build();

            DigitalOutput sariKablo = pi4j.create(config4);
            //diğital output olarak yapılandırdığımız ( BCM 6 ) adresli pini high yapalım
            sariKablo.high();
            // ------------------------------------------------------------------------------------------



            // Pini yapılandır ve oluştur
            var config5 = DigitalOutput.newConfigBuilder(pi4j)
                    .id("led_" + LED_PINS[4])
                    .name("LED Pin " + LED_PINS[4])
                    .address(LED_PINS[4])
                    .shutdown(DigitalState.LOW)// Uygulama kapanış güvenliği
                    .initial(DigitalState.LOW) // İlk açılış güvenliği
                    .build();

            DigitalOutput turuncuKablo = pi4j.create(config5);
            //diğital output olarak yapılandırdığımız ( BCM 22 ) adresli pini high yapalım
            turuncuKablo.high();
            // ------------------------------------------------------------------------------------------



            // Pini yapılandır ve oluştur
            var config6 = DigitalOutput.newConfigBuilder(pi4j)
                    .id("led_" + LED_PINS[5])
                    .name("LED Pin " + LED_PINS[5])
                    .address(LED_PINS[5])
                    .shutdown(DigitalState.LOW)// Uygulama kapanış güvenliği
                    .initial(DigitalState.LOW) // İlk açılış güvenliği
                    .build();

            DigitalOutput kirmiziKablo = pi4j.create(config6);
            //diğital output olarak yapılandırdığımız ( BCM 27 ) adresli pini high yapalım
            kirmiziKablo.high();
            // ------------------------------------------------------------------------------------------



            // Pini yapılandır ve oluştur
            var config7 = DigitalOutput.newConfigBuilder(pi4j)
                    .id("led_" + LED_PINS[6])
                    .name("LED Pin " + LED_PINS[6])
                    .address(LED_PINS[6])
                    .shutdown(DigitalState.LOW)// Uygulama kapanış güvenliği
                    .initial(DigitalState.LOW) // İlk açılış güvenliği
                    .build();

            DigitalOutput kahveKablo = pi4j.create(config7);
            //diğital output olarak yapılandırdığımız ( BCM 17 ) adresli pini high yapalım
            kahveKablo.high();
            // ------------------------------------------------------------------------------------------

            System.out.println("Program çalışıyor. Kapatmak için ENTER'a bas...");
            System.in.read();

        }catch (Exception e){
            System.err.println("Bir hata oluştu: " + e.getMessage());
            e.printStackTrace();
        }finally {
            // Kaynakları temizle ve kapat
            if (pi4j != null) {
                pi4j.shutdown();
                System.out.println("Pi4J sistemi güvenli bir şekilde kapatıldı.");
            }//end if
        }//end finally

    }//end main

}//end class

//.pull(PullResistance.PULL_DOWN) bu yapılanma diğital output için kullanılamaz sadece diğital INPUT İÇİN KULLANILABİLİR Elektriksel gürültüyü engeller  Cannot resolve method 'pull' in 'DigitalOutputConfigBuilder'