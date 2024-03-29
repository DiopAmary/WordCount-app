import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

import java.io.IOException;

public class WordCountReducer extends Reducer<Text, LongWritable, Text, LongWritable>{

    @Override
    protected void reduce(Text key, Iterable<LongWritable> listeValue, Reducer<Text, LongWritable, Text, LongWritable>.Context context) throws IOException, InterruptedException{
        long count = 0;
        for (LongWritable v : listeValue){
            count += v.get();
        }
        context.write(key, new LongWritable(count));
    }
}
