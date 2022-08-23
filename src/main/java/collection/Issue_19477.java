//import java.io.*;
//import java.nio.charset.StandardCharsets;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//import java.util.*;
//import java.util.stream.Collectors;
//
//public class Issue_19477 {
//
//
//    switch (actionName) {
//        case "connectionLeakLog": {
//            parsingConnectionLeakLog();
//            break;
//        }
//        case "communicationDiagnosticLog": {
//            parsingCommunicationDiagnosticLog();
//            break;
//        }
//
//
//        // http://localhost:8080/TrackEnsure/fleet/dev-tools?actionName=connectionLeakLog
//        public void parsingConnectionLeakLog() {
//            // строка по которой сравниваем и Нода: в ней сама целиком строка и их количество
//            Map<String, NodaLeakLog> result = new HashMap<>();
//            readAndParseLeakLogFile(result);
//            writeToFileLeakResult(result);
//            logger.info("we in DevToolsServlet -> parsingConnectionLeakLog() good");
//        }
//
//        // http://localhost:8080/TrackEnsure/fleet/dev-tools?actionName=communicationDiagnosticLog
//        public void parsingCommunicationDiagnosticLog() {
//            List<NodaCommunicationDiagnosticLog> result = new ArrayList<>();
//            readAndParseCommunicationDiagnosticLogFile(result);
//            writeToFileCommunicationDiagnosticTenResults(result);
//        }
//
//        private static class NodaCommunicationDiagnosticLog implements Comparable {
//            private Long data;
//            private String str;
//
//            public NodaCommunicationDiagnosticLog(Long data, String str) {
//                this.data = data;
//                this.str = str;
//            }
//
//            @Override
//            public int compareTo(Object o) {
//                Long dataO = ((NodaCommunicationDiagnosticLog) o).data;
//                return (int) (dataO - this.data);
//            }
//
//            public Long getData() {
//                return data;
//            }
//
//            public void setData(Long data) {
//                this.data = data;
//            }
//
//            public String getStr() {
//                return str;
//            }
//
//            public void setStr(String str) {
//                this.str = str;
//            }
//        }
//
//        private static void readAndParseCommunicationDiagnosticLogFile(List<NodaCommunicationDiagnosticLog> list) {
//            try (FileInputStream path = new FileInputStream(AppConstants.COMMUNICATION_DIAGNOSTIC_LOG_URL);
//                 BufferedReader br = new BufferedReader(new InputStreamReader(path))) {
//                String strLine;
//
//                long firstTime = 0;
//                long secondTime = 0;
//                long result = 0;
//
//                while ((strLine = br.readLine()) != null) {
//                    String[] split = strLine.split(":");
//                    String str0 = split[0];
//
//                    if (str0.equals("O")) {
//                        firstTime = Long.parseLong(split[1]);
//                    } else if (str0.equals("C")) {
//                        secondTime = Long.parseLong(split[1]);
//                        result = secondTime - firstTime;
//                        firstTime = 0;
//                        secondTime = 0;
//
//                        NodaCommunicationDiagnosticLog obj = new NodaCommunicationDiagnosticLog(result, strLine);
//                        list.add(obj);
//                    }
//                }
//            } catch (Exception ex) {
//                logger.error("ERROR: class DevToolsServlet -> readAndParseCommunicationDiagnosticLogFile() + " + ex);
//            }
//            logger.info("class DevToolsServlet -> readAndParseCommunicationDiagnosticLogFile()");
//        }
//
//        private static void writeToFileCommunicationDiagnosticTenResults(List<NodaCommunicationDiagnosticLog> result) {
//
//            Collections.sort(result);
//
//            result = result.stream().limit(10).collect(Collectors.toList());
//
//            String path = AppConstants.COMMUNICATION_DIAGNOSTIC_LOG_RESULT_URL;
//
//            File file = new File(path);
//            try (FileOutputStream fos = new FileOutputStream(file, false)) {
//
//                if (result == null) {
//                    file.createNewFile();
//                    String text = "COMMUNICATION_DIAGNOSTIC_LOG файл пустой" + "\n";
//                    byte[] buffer = text.getBytes(StandardCharsets.UTF_8);
//
//                    fos.write(buffer);
//                    fos.flush();
//                    return;
//                } else {
//                    StringBuilder sb = new StringBuilder();
//                    file.createNewFile();
//
//                    Iterator<NodaCommunicationDiagnosticLog> iterator = result.iterator();
//
//                    while (iterator.hasNext()) {
//                        NodaCommunicationDiagnosticLog noda = iterator.next();
//                        String data = String.valueOf(noda.getData());
//                        String str = noda.getStr();
//                        sb.append(data).append("  :  ").append(str).append("\n");
//                    }
//
//                    String text = sb.toString();
//                    byte[] buffer = text.getBytes(StandardCharsets.UTF_8);
//
//                    fos.write(buffer);
//                    fos.flush();
//                }
//            } catch (IOException ex) {
//                logger.error("ERROR: class DevToolsServlet -> writeToFileCommunicationDiagnosticTenResults() + " + ex);
//            }
//        }
//
//        private static void readAndParseLeakLogFile(Map<String, NodaLeakLog> result) {
//            try (FileInputStream path = new FileInputStream(AppConstants.CONNECTION_LEAK_LOG_URL);
//                 BufferedReader br = new BufferedReader(new InputStreamReader(path))) {
//                String strLine;
//                while ((strLine = br.readLine()) != null) {
//                    String[] split = strLine.split(":");
//                    String str0 = split[0];
//                    String strEquals = strLine.substring(16);
//                    if (str0.equals("O")) {
//                        if (result.get(strEquals) == null) {
//                            NodaLeakLog nodaLeakLog = new NodaLeakLog(strLine, 1);
//                            result.put(strEquals, nodaLeakLog);
//                        } else {
//                            NodaLeakLog nodaLeakLogFomResult = result.get(strEquals);
//                            int count = nodaLeakLogFomResult.getCount();
//                            nodaLeakLogFomResult.setCount(++count);
//                        }
//                    } else {
//                        if (result.get(strEquals) != null) {
//                            NodaLeakLog nodaLeakLog = result.get(strEquals);
//                            if (nodaLeakLog.getCount() == 1) {
//                                result.remove(strEquals);
//                            } else {
//                                int count = nodaLeakLog.getCount();
//                                nodaLeakLog.setCount(--count);
//                            }
//                        }
//                    }
//                }
//            } catch (Exception ex) {
//                logger.error("we in DevToolsServlet -> readAndParseLogFile() -> in catch block: " + ex);
//            }
//            logger.info("we in DevToolsServlet -> readAndParseLogFile() good");
//        }
//
//        private static void writeToFileLeakResult(Map<String, NodaLeakLog> result) {
//            String path = AppConstants.CONNECTION_LEAK_LOG_RESULT_URL;
//
//            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
//            LocalDateTime dateTime = LocalDateTime.now();
//            String time = dateTime.format(formatter);
//
//            if (result.size() == 0) {
//                File file = new File(path);
//                try (FileOutputStream fos = new FileOutputStream(file, true)) {
//                    file.createNewFile();
//                    String text = "Нет не закрытых коннекшинов! В логах все нормально, TimeNow=" + time + "\n";
//                    byte[] buffer = text.getBytes(StandardCharsets.UTF_8);
//                    fos.write(buffer);
//                    fos.flush();
//                } catch (IOException e) {
//                    e.printStackTrace();
//                }
//            } else {
//                File file = new File(path);
//                try (FileOutputStream fos = new FileOutputStream(file, true)) {
//                    file.createNewFile();
//                    String text = "ERROR: timeNow=\"" + time + " Не закрытые коннекшины:\n";
//                    byte[] buffer = text.getBytes(StandardCharsets.UTF_8);
//                    fos.write(buffer);
//                    Set<Map.Entry<String, NodaLeakLog>> entries = result.entrySet();
//                    for (Map.Entry<String, NodaLeakLog> set : entries) {
//                        NodaLeakLog nodaLeakLog = set.getValue();
//                        String text2 = nodaLeakLog.getStr() + "\n";
//                        byte[] buffer2 = text2.getBytes(StandardCharsets.UTF_8);
//                        fos.write(buffer2);
//                    }
//                    fos.flush();
//                } catch (IOException ex) {
//                    logger.error("we in DevToolsServlet -> writeToFileResult() -> in catch block: " + ex);
//                }
//            }
//            logger.info("we in DevToolsServlet -> writeToFileResult()");
//        }
//
//        private static class NodaLeakLog {
//            private String str;
//            private Integer count;
//
//            public NodaLeakLog(String str, Integer count) {
//                this.str = str;
//                this.count = count;
//            }
//
//            public String getStr() {
//                return str;
//            }
//
//            public void setStr(String str) {
//                this.str = str;
//            }
//
//            public Integer getCount() {
//                return count;
//            }
//
//            public void setCount(Integer count) {
//                this.count = count;
//            }
//        }
//
//
//        341
//        public static String CONNECTION_LEAK_LOG_URL = "/home/user/dev/TrackEnsure/logs/CONNECTION_LEAK.log";
//        public static String CONNECTION_LEAK_LOG_RESULT_URL = "/home/user/dev/TrackEnsure/logs/CONNECTION_LEAK_LOG_RESULT.txt";
//        public static String COMMUNICATION_DIAGNOSTIC_LOG_URL = "/home/user/dev/TrackEnsure/logs/COMMUNICATION_DIAGNOSTIC.log";
//        public static String COMMUNICATION_DIAGNOSTIC_LOG_RESULT_URL = "/home/user/dev/TrackEnsure/logs/COMMUNICATION_DIAGNOSTIC_LOG.txt";
//
//
//
