import java.io.*;
 
public class ExternalProgramLauncher {
 
 public static void main(String[] args) 
  throws IOException, InterruptedException {
 
  // указываем в конструкторе ProcessBuilder,
  // что нужно запустить программу ls с параметрами -l /dev
  ProcessBuilder procBuilder = new ProcessBuilder("ls","-l","/dev");  
   
  // перенаправляем стандартный поток ошибок на
  // стандартный вывод
  procBuilder.redirectErrorStream(true);
  
  // запуск программы
  Process process = procBuilder.start();
  
  // читаем стандартный поток вывода
  // и выводим на экран
  InputStream stdout = process.getInputStream();
  InputStreamReader isrStdout = new InputStreamReader(stdout);
  BufferedReader brStdout = new BufferedReader(isrStdout);
 
  String line = null;
  while((line = brStdout.readLine()) != null) {
   System.out.println(line);
  }
   
  // ждем пока завершится вызванная программа
  // и сохраняем код, с которым она завершилась в 
  // в переменную exitVal
  int exitVal = process.waitFor();
 }
}