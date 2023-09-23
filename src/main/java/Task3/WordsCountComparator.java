package Task3;

import java.util.Comparator;

class WordsCountComparator implements Comparator<Word> {
    @Override
    public int compare(Word o1,Word o2) {
        if(o2.getCounter()>o1.getCounter()){
            return 1;
        } else if (o1.getCounter()>o2.getCounter()) {
            return -1;
        } else{
            return 0;
        }

    }
}