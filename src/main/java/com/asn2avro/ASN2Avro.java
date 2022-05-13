package com.asn2avro;

import com.cdr.CDR;
import org.apache.avro.file.DataFileWriter;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.specific.SpecificDatumWriter;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.apache.avro.io.DatumReader;
import org.apache.avro.file.DataFileReader;
import org.apache.avro.specific.SpecificDatumReader;
public class ASN2Avro {
    public static void main(String[] args) throws IOException {
        // STEP 1: Import ASN1 file
        String file = new String(Files.readAllBytes(Paths.get("D:\\DATA\\Level 04\\Graduation project\\Test\\Pre-Processing\\Kareem_1652393980269.asn1")));

        // STEP 2: Extract HEX fields
        List<StringBuilder> allNumberA = getHexNumberA(file);
        List<StringBuilder> allNumberB = getHexNumberB(file);
        List<StringBuilder> allHexTimestamp = getHexTimestamp(file);
        List<StringBuilder> allHexDurations = getHexDuration(file);

        // STEP 3: Convert HEX Fields into readable data
        allNumberA.replaceAll(ASN2Avro::toPhoneNumber);
        allNumberB.replaceAll(ASN2Avro::toPhoneNumber);
        /*
            Notice that getHexTimestamp & getHexDuration methods return types are StringBuilder while we want them long & int
            So we should create a new List with different data type.
         */
        List<Long> allTimestamp = new ArrayList<>();
        for(StringBuilder hexTimestamp : allHexTimestamp){
            allTimestamp.add(toTimestamp(hexTimestamp));
        }
        List<Integer> allDuration = new ArrayList<>();
        for(StringBuilder hexDuration : allHexDurations){
            allDuration.add(toDuration(hexDuration));
        }

        // Step 4: Write data in avro file
        final DatumWriter<CDR> datumWriter = new SpecificDatumWriter<>(CDR.class);
        try (DataFileWriter<CDR> dataFileWriter = new DataFileWriter<>(datumWriter)) {
            CDR.Builder cdrBuilder = CDR.newBuilder();
            CDR cdr = new CDR();
            dataFileWriter.create(cdr.getSchema(), new File("CDR File.avro"));
            for (int i = 0; i < allNumberA.size(); i++) {
                cdrBuilder.setNumberA(allNumberA.get(i).toString());
                cdrBuilder.setNumberB(allNumberB.get(i).toString());
                cdrBuilder.setTimestamp(allTimestamp.get(i));
                cdrBuilder.setDuration(allDuration.get(i));
                cdr = cdrBuilder.build();
                dataFileWriter.append(cdr);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }

        // Testing
//        System.out.println(allNumberA);
//        System.out.println(allNumberB);
//        System.out.println(allTimestamp);
//        System.out.println(allDuration);

//        final File avroFile = new File("CDR File.avro");
//        final DatumReader<CDR> datumReader = new SpecificDatumReader<>(CDR.class);
//        final DataFileReader<CDR> dataFileReader;
//        try {
//            System.out.println("Read");
//            dataFileReader = new DataFileReader<>(avroFile, datumReader);
//            while (dataFileReader.hasNext()) {
//                CDR readCustomer = dataFileReader.next();
//                System.out.println(readCustomer.toString());
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
    public static List<StringBuilder> getHexNumberA(String file) {
        List<StringBuilder> allNumberA = new ArrayList<>();
        Pattern pattern = Pattern.compile("a6 13 81 11 74 65 6c 3a 2b 32 30 31 .. .. .. .. .. .. .. .. .. *");
        Matcher matcher = pattern.matcher(file);
        while (matcher.find()) {
            allNumberA.add(new StringBuilder(matcher.group().substring(36, 62)));
        }
        return allNumberA;
    }
    public static List<StringBuilder> getHexNumberB(String file) {
        List<StringBuilder> allNumberB = new ArrayList<>();
        Pattern pattern = Pattern.compile("a7 13 81 11 74 65 6c 3a 2b 32 30 31 .. .. .. .. .. .. .. .. .. *");
        Matcher matcher = pattern.matcher(file);
        while (matcher.find()) {
            allNumberB.add(new StringBuilder(matcher.group().substring(36, 62)));
        }
        return allNumberB;
    }
    public static List<StringBuilder> getHexTimestamp(String file) {
        List<StringBuilder> allDateTime = new ArrayList<>();
        Pattern pattern = Pattern.compile("89 09 .. .. .. .. .. .. 2B 02 00 *");
        Matcher matcher = pattern.matcher(file);
        while (matcher.find()) {
            allDateTime.add(new StringBuilder(matcher.group().substring(6, 23)));
        }
        return allDateTime;
    }
    public static List<StringBuilder> getHexDuration(String file) {
        List<StringBuilder> allDuration = new ArrayList<>();
        Pattern pattern = Pattern.compile("9f 81 48 0. .. .. ..*");
        Matcher matcher = pattern.matcher(file);
        while (matcher.find()) {
            switch (matcher.group().charAt(10)) {
                case '4':
                    allDuration.add(new StringBuilder(matcher.group().substring(12, 23)));
                    break;
                case '3':
                    allDuration.add(new StringBuilder(matcher.group().substring(12, 20)));
                    break;
            }
        }
        return allDuration;
    }
    public static StringBuilder toPhoneNumber(StringBuilder hexPhone) {
        hexPhone.replace(0, 0, "01");
        for (int i = 2; i < 19; i+=2) {
            hexPhone.deleteCharAt(i);
        }
        return new StringBuilder(hexPhone.toString().replace(" ", ""));
    }
    public static long toTimestamp(StringBuilder hexDateTime) {
        hexDateTime.insert(0, "20");
        Date date = null;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy MM dd HH mm ss");
        try {
            date = dateFormat.parse(hexDateTime.toString());
        }
        catch (ParseException e) {
            e.printStackTrace();
        }
        return date.getTime();
    }
    public static int toDuration(StringBuilder hexDuration) {
        return (Integer.parseInt(hexDuration.toString().replace(" ", ""), 16) / 100000);
    }
}