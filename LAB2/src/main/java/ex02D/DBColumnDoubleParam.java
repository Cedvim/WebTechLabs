package ex02D;

public class DBColumnDoubleParam extends DBColumn {
    protected int colScale;
    protected int colPrecision;
            
    //Column with double params
    protected DBColumnDoubleParam(final String colName, final String colType, final String isNullable, final int colSize, final int colScale, final String isAutoIncrement) {
        super(colName, colType, isNullable, colSize, isAutoIncrement);  
        this.colScale = colScale;
        this.colPrecision = colSize;
    }

    //Conversion to sql instructions of the double param column
    @Override
    public String toSQL() {
    	
        final StringBuffer sb = new StringBuffer();
        sb.append(String.format("\n%s %s(%d, %d) %s%s,", this.getName(), this.getColType(), this.colPrecision, this.colScale, this.getIsNullable(), this.getIsAutoIncrement()));

        return sb.toString();
    }

    public int getColScale() {
        return colScale;
    }

    public int getColPrecision() {
        return colPrecision;
    }
    
    
}
