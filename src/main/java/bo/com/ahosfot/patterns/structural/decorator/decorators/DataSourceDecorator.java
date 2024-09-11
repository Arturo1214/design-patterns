package bo.com.ahosfot.patterns.structural.decorator.decorators;

public class DataSourceDecorator implements DataSource {

    private DataSource wrappedDataSource;

    public DataSourceDecorator(DataSource wrappedDataSource) {
        this.wrappedDataSource = wrappedDataSource;
    }

    @Override
    public void writeData(String data) {
        this.wrappedDataSource.writeData(data);
    }

    @Override
    public String readData() {
        return this.wrappedDataSource.readData();
    }
}
