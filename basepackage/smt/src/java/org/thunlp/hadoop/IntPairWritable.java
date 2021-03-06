package org.thunlp.hadoop;

import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;

import org.apache.hadoop.io.WritableComparable;

public class IntPairWritable implements WritableComparable {
	public int first;
	public int second;

	public void readFields(DataInput in) throws IOException {
		first = in.readInt();
		second = in.readInt();
	}

	public void write(DataOutput out) throws IOException {
		out.writeInt(first);
		out.writeInt(second);
	}

	public int compareTo(Object o) {
		if (o instanceof IntPairWritable) {
			IntPairWritable other = (IntPairWritable) o;
			int cmp = first - other.first;
			if (cmp == 0)
				cmp = second - other.second;
			return cmp;
		}
		return -1;
	}

	public String toString() {
		return first + " " + second;
	}

}
