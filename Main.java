public class Main {
    public static void main(String [] args){


        Buffer sc = new Buffer(80,25,'@');
        sc.DrawLine(0,0, 79, 24, '.');;
        sc.DrawLine(0, 24, 79, 0, '-');
        sc.DrawRect(5,5,75,15,'*');
        sc.DrawFill(10, 10, 'f');
        sc.DrawFill( 76, 12, 'g');
        sc.WriteCenter(9, 9, "This text is centered around 9,9");
        sc.WriteChar(9, 9, 'O');
        sc.Display();

    }
}
