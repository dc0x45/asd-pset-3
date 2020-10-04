public class SimpleStack{

    int size = 0;
    private element head;
    private element tail;

    public SimpleStack(){
        size = 0;
        head = null;
        tail = null;
    }
    public String push(String item){
        element track = head;
        if (track == null){
            head = new element(null, item, null);
            tail = head;
            size = 1;
        } else {
            element toAppend = new element(null, item, track);
            head = toAppend;
            head.next.prev = head;
            size++;
        }
        return item;
    }
    public String pop(){
        String returnMe = null;
        if (head != null){
            returnMe = head.data;
            head.next = head;
            head.prev = null;
            size--;
        }
        return returnMe;
    }
    public String peek(){
        String returnMe = null;
        if (head != null){
            returnMe = head.data;
        }
        return returnMe;
    }
    public boolean empty(){
        if (size == 0){
            return true;
        } else return false;
    }
    public int search(String s){
        int internalCount = 0;
        boolean breakMe = true;
        element track = head;
        while(track != null && breakMe){
            if (track.data == s){
                breakMe = false;
            } else {
                track = track.next;
                internalCount++;
            }
        }
        if (breakMe){
            return -1;
        } else return ++internalCount;
    }
    public String toString(){
        String finalString = "";
        element track = tail;
        for (int i = size; i > 0; i--){
            if (i == size){
                finalString = track.data;
            } else{
                finalString = finalString + ", " + track.data;
            }
            track = track.prev;

        }
        return "[" + finalString + "]";
    }
    private static class element {

        element prev;
        String data;
        element next;

        public element(element prev, String data, element next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }
}