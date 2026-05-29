import com.pi4j.Pi4J;
import com.pi4j.context.Context;
import com.pi4j.io.gpio.digital.DigitalOutput;
import com.pi4j.io.gpio.digital.DigitalState;

public class Main {

    @SuppressWarnings("removal") // address() metodundaki deprecated uyarısını susturur
    public static void main() {
        // BCM Pinleri: 26, 19, 13, 6, 22, 27, 17
        int[] LED_PINS = {26, 19, 13, 6, 22, 27, 17};

        // DigitalOutput OLACAK pinleri saklamak için dizi
        DigitalOutput[] kablolar = new DigitalOutput[LED_PINS.length];

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

            //mor kabloya bağlı pini DIGITAL OUTPUT YAP ( BCM 26 )
            kablolar[0] = pi4j.create(config1);
            //diğital output olarak yapılandırdığımız bcm26 adresli pini high yapalım
            kablolar[0].high();
            // ------------------------------------------------------------------------------------------



            // Pini yapılandır ve oluştur
            var config2 = DigitalOutput.newConfigBuilder(pi4j)
                    .id("led_" + LED_PINS[1])
                    .name("LED Pin " + LED_PINS[1])
                    .address(LED_PINS[1])
                    .shutdown(DigitalState.LOW)// Uygulama kapanış güvenliği
                    .initial(DigitalState.LOW) // İlk açılış güvenliği
                    .build();

            //mavi kabloya bağlı pini DIGITAL OUTPUT YAP ( BCM 19 )
            kablolar[1] = pi4j.create(config2);
            //diğital output olarak yapılandırdığımız bcm19 adresli pini high yapalım
            kablolar[1].high();
            // ------------------------------------------------------------------------------------------



            // Pini yapılandır ve oluştur
            var config3 = DigitalOutput.newConfigBuilder(pi4j)
                    .id("led_" + LED_PINS[2])
                    .name("LED Pin " + LED_PINS[2])
                    .address(LED_PINS[2])
                    .shutdown(DigitalState.LOW)// Uygulama kapanış güvenliği
                    .initial(DigitalState.LOW) // İlk açılış güvenliği
                    .build();

            //yeşil kabloya bağlı pini DIGITAL OUTPUT YAP ( BCM 13 )
            kablolar[2] = pi4j.create(config3);
            //diğital output olarak yapılandırdığımız bcm13 adresli pini high yapalım
            kablolar[2].high();
            // ------------------------------------------------------------------------------------------



            // Pini yapılandır ve oluştur
            var config4 = DigitalOutput.newConfigBuilder(pi4j)
                    .id("led_" + LED_PINS[3])
                    .name("LED Pin " + LED_PINS[3])
                    .address(LED_PINS[3])
                    .shutdown(DigitalState.LOW)// Uygulama kapanış güvenliği
                    .initial(DigitalState.LOW) // İlk açılış güvenliği
                    .build();

            //sarı kabloya bağlı pini DIGITAL OUTPUT YAP ( BCM 6 )
            kablolar[3] = pi4j.create(config4);
            //diğital output olarak yapılandırdığımız bcm6 adresli pini high yapalım
            kablolar[3].high();
            // ------------------------------------------------------------------------------------------



            // Pini yapılandır ve oluştur
            var config5 = DigitalOutput.newConfigBuilder(pi4j)
                    .id("led_" + LED_PINS[4])
                    .name("LED Pin " + LED_PINS[4])
                    .address(LED_PINS[4])
                    .shutdown(DigitalState.LOW)// Uygulama kapanış güvenliği
                    .initial(DigitalState.LOW) // İlk açılış güvenliği
                    .build();

            //turuncu kabloya bağlı pini DIGITAL OUTPUT YAP ( BCM 22 )
            kablolar[4] = pi4j.create(config5);
            //diğital output olarak yapılandırdığımız bcm22 adresli pini high yapalım
            kablolar[4].high();
            // ------------------------------------------------------------------------------------------


            // Pini yapılandır ve oluştur
            var config6 = DigitalOutput.newConfigBuilder(pi4j)
                    .id("led_" + LED_PINS[5])
                    .name("LED Pin " + LED_PINS[5])
                    .address(LED_PINS[5])
                    .shutdown(DigitalState.LOW)// Uygulama kapanış güvenliği
                    .initial(DigitalState.LOW) // İlk açılış güvenliği
                    .build();

            //kırmızı kabloya bağlı pini DIGITAL OUTPUT YAP ( BCM 27 )
            kablolar[5] = pi4j.create(config6);
            //diğital output olarak yapılandırdığımız bcm27 adresli pini high yapalım
            kablolar[5].high();
            // ------------------------------------------------------------------------------------------



            // Pini yapılandır ve oluştur
            var config7 = DigitalOutput.newConfigBuilder(pi4j)
                    .id("led_" + LED_PINS[6])
                    .name("LED Pin " + LED_PINS[6])
                    .address(LED_PINS[6])
                    .shutdown(DigitalState.LOW)// Uygulama kapanış güvenliği
                    .initial(DigitalState.LOW) // İlk açılış güvenliği
                    .build();

            //kahve kabloya bağlı pini DIGITAL OUTPUT YAP ( BCM 17 )
            kablolar[6] = pi4j.create(config7);
            //diğital output olarak yapılandırdığımız bcm17 adresli pini high yapalım
            kablolar[6].high();
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