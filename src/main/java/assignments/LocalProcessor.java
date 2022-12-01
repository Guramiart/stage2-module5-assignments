package assignments;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

import assignments.annotations.FullNameProcessorGeneratorAnnotation;
import assignments.annotations.ListIteratorAnnotation;
import assignments.annotations.ReadFullProcessorNameAnnotation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LocalProcessor {
    private String processorName;
    private Long period = 10000000000000L;
    protected String processorVersion;
    private Integer valueOfCheap;
    private Scanner informationScanner;
    private List<String> stringArrayList;

    public LocalProcessor(String processorName, Long period, String processorVersion, Integer valueOfCheap,
                          Scanner informationScanner, List<String> stringArrayList) {
        this.processorName = processorName;
        this.period = period;
        this.processorVersion = processorVersion;
        this.valueOfCheap = valueOfCheap;
        this.informationScanner = informationScanner;
        this.stringArrayList = stringArrayList;
    }

    public LocalProcessor() {
    }

    @ListIteratorAnnotation
    public void listIterator(List<String> stringList) {
        stringArrayList = new LinkedList<>(stringList);
        Logger logger = Logger.getLogger(LocalProcessor.class.getSimpleName());
        for (String elem : stringArrayList) {
            logger.log(Level.INFO, String.valueOf(elem.hashCode()));
        }
    }

    @FullNameProcessorGeneratorAnnotation
    public String fullNameProcessorGenerator(List<String> stringList) {
        stringArrayList = new LinkedList<>(stringList);
        StringBuilder stringBuilder = new StringBuilder();
        for (String elem : stringArrayList) {
            stringBuilder.append(elem).append(" ");
        }
        processorName = stringBuilder.toString();
        return processorName;
    }

    @ReadFullProcessorNameAnnotation
    public void readFullProcessorName(File file) throws FileNotFoundException {
            informationScanner = new Scanner(file);
            StringBuilder stringBuilder = new StringBuilder();
            while (informationScanner.hasNext()) {
                stringBuilder.append(informationScanner.nextLine());
            }
            processorVersion = stringBuilder.toString();
    }
}
