package my.vis;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SortingText {
    SimpleDateFormat formating = new SimpleDateFormat("mm:ss:SSS");
    String [] WordCombinnation= new String [50];
        int k=0;
    FileReed filR= new FileReed();
    //класс записи в файл
    SaveFile seveF=new SaveFile();    
    String time=" ";    
    String [] words;
    String [] words1;
    int massLenght;
    //VisUi classBar= new VisUi();
    // массив слов текста
    int [] count;//масив подсчета одинаковых слов
    int textLenght;// кол-во слов текста
    int sort;//колво слов сортировки
    String [] printWords;//массив осортированых слов
    String [] printWordsAbr;//массив аббревиатур
    int porN =0;//счетчик для аббривиатур
    int porN1 =0;//счетчик для отсортированных слов
    String lastWord;
	//метод проверки слова на аббревиатуру
	public static boolean test(String testString){  
        Pattern p = Pattern.compile("[A-Z][A-Z]+");  
        Matcher m = p.matcher(testString);  
        return m.matches();  
    } 
	//Убираем знаки припинания и сортитируем слова по возрастанию кол-ва одинаковых
	public void Sorting() throws IOException{
            //Считываем файл
            filR.Reed();           
        //убираем знаки 
            words1=filR.s.split(" ");
            textLenght=words1.length;
            massLenght=textLenght;
            //System.out.println("длина первоначального массива слов "+textLenght);               
        for (int i=0;i < textLenght;i++){
            words1[i]=words1[i].replace(",", "");
            words1[i]=words1[i].replace("(", "");
            words1[i]=words1[i].replace(")", "");
    	    words1[i]=words1[i].replace(".", "");
            words1[i]=words1[i].replace("\"", "");
    	    words1[i]=words1[i].replace("!", "");
    	    words1[i]=words1[i].replace("?", "");
    	    words1[i]=words1[i].replace(":", "");
    	    words1[i]=words1[i].replace(";", "");
    	    words1[i]=words1[i].replace(" ", "");
    	    words1[i]=words1[i].replace(" ", "");
    	    words1[i]=words1[i].replace("’", "");
    	    words1[i]=words1[i].replace("”", "");
    	    words1[i]=words1[i].replace("—", " ");
    	    words1[i]=words1[i].replace("-", " ");
    	    words1[i]=words1[i].replace("“", "");
    	    words1[i]=words1[i].replace("•", "");
            words1[i]=words1[i].replace("'", "");
            words1[i]=words1[i].replace("_", "");
            words1[i]=words1[i].replace("  ", " ");
            words1[i]=words1[i].replace("\n", "");
        }
        lastWord= words1[textLenght-1];
        System.out.println("убрали знаки" + formating.format(Calendar.getInstance().getTime()));
       // classBar.jProgressBar1.setValue(20);
        
            for (int i = 0; i < words1.length; i++) {
                if (words1[i].compareToIgnoreCase("service partner") == 0 ){
                    WordCombinnation[k]=words1[i];
                k=k+1;
                }
            }

        //убираем слова меньше пяти букв и заменяем их на пробелы        
            for (int i = 0; i <textLenght; i++) {
                //words1[i]=words1[i].trim();
                if (words1[i].length()<5 )
                    words1[i]="";
            }
            for (int i = 0; i <textLenght; i++) {
                if (words1[i].compareTo(" ") == 0 )
                    words1[i]="";
            }
            System.out.println("убрали слова меньше 5 букв" + formating.format(Calendar.getInstance().getTime()));
            //записываем массив в стриговую переменую 
            for (int i = 0; i < textLenght; i++) {
                if (words1[i].compareTo(" ") == 0 || words1[i].compareTo("") == 0)
                    time=time;
                else
                    time=time+words1[i]+" ";
            }
           System.out.println("записали массив в переменную" + formating.format(Calendar.getInstance().getTime()));
            //создаем временный файл
            //seveF.write("/home/linma/java/Time.txt",time);
            //System.out.println("создали временный файл");
            
        //записываем новый текст
            words=time.split(" ");
            textLenght=words.length;
                        
            System.out.println("длина масива слов " + textLenght + formating.format(Calendar.getInstance().getTime()));
            //номер в массиве последнего слова
        
        count = new int [textLenght];
        //считаем кол-во одинаковых слов 
        int j1=1;
        for (int i=0;i < textLenght;i++){            
        	for (int j=j1 ;j<textLenght;j++){        		
        		if (words[i].compareToIgnoreCase(words[j]) == 0)
        			count[i]++;
                        }
                count[i]=count[i]+1;
                //if(words[i].compareToIgnoreCase("young") == 0)
                    //System.out.println(words[i]+" кол-во "+count[i]);
                j1=j1+1;
                //System.out.println(words[i]+" сортируем по возростанию "+count[i]);
        }
        //сортируем по возростанию  
        System.out.println("сортируем по возростанию" + formating.format(Calendar.getInstance().getTime()));
        for(int i=0;i<textLenght-1;i++){
        	 for(int j=i+1;j<textLenght;j++){
        	  if(count[i]>count[j]){
        	       int tmp=count[i];
        	       count[i]=count[j];
        	       count[j]=tmp;
        	       String tmpS=words[i];
        	       words[i]=words[j];
        	       words[j]=tmpS;
        	  }
        	 }
        	}
        System.out.println("сортировка закончена" + formating.format(Calendar.getInstance().getTime()));
        }
        
        String getWords(int number){            
		return printWords[number];		
	}
        String getWordsAbr(int number){
		return printWords[number];		
	}
        void setWords (int number, String word){            
            printWords[number]=word;
        }
        void setWordsAbr (int number, String word){            
            printWordsAbr[number]=word;
        }
        //кол-во слов для сортироаки
        void  setTWordSorting (int sort){
            this.sort=sort;            
        }
        //путь к фаулу
        void setPart(String part){
            filR.part=part;            
        }
        //выводим на печать кол-во слов больше "N" сиволов  и аббревиатуры
        
        void print(){ 
                    //System.out.println("готовим на печать");

            printWords=new String [textLenght];
            printWordsAbr=new String [50];            
        for (int i=textLenght-1 ;i >=0 ;i--){
        	//Вывод аббревиатуры            
        	if (test(words[i]) ){                    
        		          setWordsAbr(porN,(Integer.toString(count[i])+"-----"+words[i]));
                                  porN++;
                                  //System.out.println(count[i]+"-----"+words[i]);
                }
                for (int j=0;j<textLenght;j++){
                    if (words[i].length()<5 )
                        count[i]=0;
                    if (words[i].compareToIgnoreCase(words[j])==0 && count[i]>count[j] && count[i]>sort){                        
                        count[j]=0;
                        //System.out.println("---------- "+words[j]);
                    }
                }
        	//Вывод искомых слов	
        	if (count[i]>sort && count[i]!=0){
                    setWords(porN1,(Integer.toString(count[i])+"-----"+words[i]));                    
                    porN1++;                    
                }
                
                
                //System.out.println("проверили слово № "+count[i]+"-----"+words[i]);
                        
                }  
        
        }
        
}