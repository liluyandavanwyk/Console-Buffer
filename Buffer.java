public class Buffer {

    int width, height;
    char fillCharector;
    char[][] screenBuffer;

    public Buffer(int width, int height, char fillCharector)
    {
        this.width=width;
        this.height=height;
        this.fillCharector = fillCharector;
        screenBuffer = new char[height][width];

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                screenBuffer[i][j]=fillCharector;
            }
        }
    }
    public void DrawFill(int x, int y, char fillChar)
    {
        if(screenBuffer[y][x] == '@' ){
            screenBuffer[y][x] = fillChar;
            if(x+1<this.width)
                DrawFill(x+1, y, fillChar);
            if(y+1<this.height)
                DrawFill(x, y+1, fillChar);
            if(!(x-1<0))
                DrawFill(x-1, y, fillChar);
            if(!(y-1<0))
                DrawFill(x, y-1, fillChar);

        }
    }

    public void WriteCenter(int x, int y, String text)
    {
        int uperHalf=(text.length()/2)+1;
        int lowerHalf=uperHalf-1;
        for (int i = x; i < this.height; i++) {
            if(uperHalf<text.length())
                this.screenBuffer[y][i]=text.charAt(uperHalf++);
        }
        for (int i = x; i >-1;--i) {
            if(!(lowerHalf<0))
                this.screenBuffer[y][i]=text.charAt(lowerHalf--);
        }
    }

    public void WriteChar(int x, int y, char chr)
    {
        try {
            this.screenBuffer[y][x]=chr;
        }
        catch (IndexOutOfBoundsException e){
            System.out.println("Invalid inmput @WriteChar()");
        }
    }

    public  void DrawRect(int x, int y, int x2, int y2, char drawChar)
    {
        for (int i = y; i < y2; i++) {
            for (int j = y; j < x2; j++) {
                this.screenBuffer[y][j]=drawChar;
                this.screenBuffer[y2][j]=drawChar;
            }
            this.screenBuffer[i][x]=drawChar;
            this.screenBuffer[i][x2]=drawChar;
        }
    }

    public String toString()
    {
        String finalString="";
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                finalString += this.screenBuffer[i][j];
            }
            finalString+='\n';
        }
        return finalString;
    }

    public void Display(){
        System.out.println(toString());
    }
/*
*The DrawLine method does mot produce the exact same line as the sample
*This is due to the straight line approximation formula Y=mx+c
* */
    public  void DrawLine(float x1, float y1, float x2, float y2, char drawChar) {
        float x, y, dx, dy, step;

        dx=x2-x1;
        dy=y2-y1;

        if(Math.abs(dx)>= Math.abs(dy))
            step=Math.abs(dx);
        else
            step=Math.abs(dy);
        dx/=step;
        dy/=step;

        x=x1;
        y=y1;
        int i=1;
        while (i<= step){
            x+=dx;
            y+=dy;
            i+=1;
            screenBuffer[(int)y][(int)x]=drawChar;
        }

    }
}
