package cn.jy.handler;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

public class DateTypeHandler extends BaseTypeHandler<Date> {
    //��Java����ת�������ݿ���Ҫ�����ͣ���String->Varchar
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Date date, JdbcType jdbcType) throws SQLException {
        long time = date.getTime();
        preparedStatement.setLong(i,time);
    }
    //�����ݿ��е�����ת����Java����
    //String����     Ҫת�����ֶε�����
    //ResultSet     ��ѯ���Ľ����
    @Override
    public Date getNullableResult(ResultSet resultSet, String i) throws SQLException {
        //��ȡ���������Ҫ������(long)ת����Date���ͷ���
        long aLong = resultSet.getLong(i);
        Date date = new Date(aLong);
        return date;
    }
    //�����ݿ��е�����ת����Java����
    @Override
    public Date getNullableResult(ResultSet resultSet, int i) throws SQLException {
        long aLong = resultSet.getLong(i);
        Date date = new Date(aLong);
        return date;
    }
    //�����ݿ��е�����ת����Java����
    @Override
    public Date getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        long aLong = callableStatement.getLong(i);
        Date date = new Date(aLong);
        return date;
    }





}
