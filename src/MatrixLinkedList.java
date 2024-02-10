import java.util.ArrayList;
import java.util.NoSuchElementException;
public class MatrixLinkedList {
    private static class MatrixNode{
        int data;
        MatrixNode next;
        MatrixNode down;
        MatrixNode(int data){
            this.data=data;
            next=null;
            down=null;
        }
    }
   private MatrixNode head;
   private int rows;
   private int columns;
   public MatrixLinkedList(){
       head=null;
       rows=0;
       columns=0;
   }
    private void checkIndex(int index, int maxIndex) {
        if (index < 0 || index >= maxIndex) {
            try {
                throw new IndexOutOfBoundsException("Invalid Index");
            }
          catch (IndexOutOfBoundsException e){
              System.out.println(e.getMessage());
          }
                System.exit(-1);
        }

    }
    private void isEmpty(){
        if (head==null)
            try {
                throw new NoSuchElementException("The matrix is Empty");
            }
        catch (NoSuchElementException e){
            System.out.println(e.getMessage());
            System.exit(-1);
        }


    }
   public ArrayList<Integer> getRow(int rowIndex){
       isEmpty();
        checkIndex(rowIndex,rows);
        int i=0;
        MatrixNode tempdown=head;
        while (i<rowIndex){
            i++;
            tempdown=tempdown.down;
        }
        ArrayList<Integer> row=new ArrayList<>();
        while (tempdown!=null){
            row.add(tempdown.data);
            tempdown=tempdown.next;
        }
        return row;
    }
   public ArrayList<Integer> getColumn(int columnIndex){
       isEmpty();
       checkIndex(columnIndex,columns);
        int i=0;
        MatrixNode temp=head;
        while (i<columnIndex){
            i++;
            temp=temp.next;
        }
        ArrayList<Integer> column=new ArrayList<>();
        while (temp!=null){
            column.add(temp.data);
            temp=temp.down;
        }
        return column;
    }
   public int rowSum(int rowIndex){
       isEmpty();
       checkIndex(rowIndex,rows);
        int i=0;
        MatrixNode tempdown=head;
        while (i<rowIndex){
            i++;
            tempdown=tempdown.down;
        }
       int sum=0;

        while (tempdown!=null){
            sum+=tempdown.data;
            tempdown=tempdown.next;
        }
        return sum;
    }
   public double columnAverage(int columnIndex){
       isEmpty();
       checkIndex(columnIndex,columns);
        int i=0;
        MatrixNode tempnext=head;
        while (i<columnIndex){
            i++;
            tempnext=tempnext.next;
        }
       double sum=0;

        while (tempnext!=null){
            sum+=tempnext.data;
            tempnext=tempnext.down;

        }
        return sum/rows;
    }
   public void replaceData(int rowIndex, int colIndex, int newData){
        isEmpty();
        checkIndex(colIndex,columns);
        checkIndex(rowIndex,rows);
       MatrixNode temp=getNode(rowIndex,colIndex);
        temp.data=newData;
    }
   public boolean Find(int data){
      isEmpty();
       MatrixNode tempdown=head;
       MatrixNode tempnext=head;
       while (tempnext!=null) {
           while (tempdown != null) {
               if (tempdown.data == data) {
                   return true;
               }
               tempdown = tempdown.down;
           }
           tempnext=tempnext.next;
           tempdown=tempnext;
       }
        return false;
   }
   public void scalarMultiply(int scalar){
       isEmpty();
        MatrixNode tempdown=head;
        MatrixNode tempnext=head;
        while (tempnext!=null) {
            while (tempdown != null) {
               tempdown.data*=scalar;
                tempdown = tempdown.down;
            }
            tempnext=tempnext.next;
            tempdown=tempnext;
        }
    }
   public String toString(){
     isEmpty();
       return toString(head);
   }
     private String toStringrow(MatrixNode node){
       if (node==null)
           return "";
       return node.data+" "+toStringrow(node.next);
    }
     private String toString(MatrixNode node){
       if (node==null)
           return "";
       return toStringrow(node)+"\n"+toString(node.down);
    }
    public void createMatrix(ArrayList<Integer>[] matrixData){
        if (matrixData.length==0)
            throw new NoSuchElementException("Can't create a matrix the array is empty");
        columns=matrixData[0].size();
        rows=matrixData.length;
        head=new MatrixNode(matrixData[0].get(0));
        MatrixNode temp=head;
        MatrixNode down=head;
            for (int i=0;i<rows;i++){
                for (int j=1;j<columns;j++){
                    temp.next=new MatrixNode(matrixData[i].get(j));
                    temp=temp.next;
                }
                if (i<rows-1) {
                    temp = down;
                    temp.down = new MatrixNode(matrixData[i + 1].get(0));
                    temp = temp.down;
                }
            down=down.down;
        }
            temp=head;
            down=head.down;
            MatrixNode ref=head.down;
        while (ref!=null) {
            while (temp != null) {
                temp.down = down;
                temp = temp.next;
                down = down.next;
            }
            temp = ref;
            down = ref.down;
            ref=ref.down;
        }
    }
    private MatrixNode getNode(int row,int col){

       MatrixNode temp=head;
       int i=0;
        while (temp.next!=null&&i<col){
            temp=temp.next;
            i++;
        }
        i=0;
       while (temp.down!=null&&i<row){
           i++;
           temp=temp.down;
       }
       return temp;
    }
    public void join(MatrixLinkedList matrix){
        isEmpty();
        var temp=head;
        var down=head.down;
        int i;
        int j=0;
        while (j<matrix.rows){
            i=0;
            while (temp.next!=null) {
                temp = temp.next;
            }
            while (i<matrix.columns){
                temp.next=new MatrixNode(matrix.getNode(j,i).data);
                temp=temp.next;
                i++;
            }
            j++;
            temp=down;
            if (down==null){
                break;
            }
            down=down.down;
        }
    }
    public void add(MatrixLinkedList matrix) {
        isEmpty();
        matrix.isEmpty();
        var temp = head;
        var down = head.down;
        var matrixtemp = matrix.head;
        var matrixdown = matrixtemp.down;
        while (true) {
            while (temp != null && matrixtemp != null) {
                temp.data = temp.data + matrixtemp.data;
                temp = temp.next;
                matrixtemp = matrixtemp.next;
            }
            temp = down;
            matrixtemp = matrixdown;
           if (down == null || matrixdown == null) {
                break;
            }
            down = down.down;
            matrixdown = matrixtemp.down;
        }
    }



}





















