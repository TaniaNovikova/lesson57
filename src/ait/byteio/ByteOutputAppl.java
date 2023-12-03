package ait.byteio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ByteOutputAppl {
    public static void main(String[] args) {//FileOutputStream может создать файл,
        // но не может создать директорию, поэтому если нужно создать файл в несуществующей
        // директории, получаем ошибку
        //нижеприведенный метод try - это не обычный try, а "try с ресурсами",
        // в скобках у него не пусто. По завешении работы этого try будет выполнен
        // close автоматически
        try (FileOutputStream fout = new FileOutputStream("./dest/test");
        ){
            fout.write(65);//65 соответсвует букве А в таблице аски
            fout.write(27);
            fout.write(257);
            fout.write(1);
            fout.close();//после того, как поток завершен, его надо закрыть,
            // так как если этого не сделать, соединение будет удеживаться,
            // а это пожирает ресурсы операционной системы
            //После того как мы открыли файл на запись, операционная система
            // поддерживает связь нашей аппликации с этим файлом. Если поток не закрыть,
            // апликация будет продолжать работать после того, как мы уже все сделали,
            // для того чтобы удерживать соединение
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){//все методы ввода-вывода бросают эксепшн на тот случай,
            // если файл будет не найден
            e.printStackTrace();//выбираем не тот ексепшн, который стоит по умолчанию,
            // а тот, который объяснит конкретно, в чем ошибка
        }
    }
}
