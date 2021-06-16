package com.mr.tengyu.wandroid.data.local_db;

import com.mr.tengyu.wandroid.base.BaseApp;
import com.mr.tengyu.wandroid.dao.BeanDao;
import com.mr.tengyu.wandroid.dao.DaoMaster;
import com.mr.tengyu.wandroid.dao.DaoSession;
import com.mr.tengyu.wandroid.data.entity.Bean;

import java.util.List;

public class MyDatabaseHelper {
    private static MyDatabaseHelper myDatabaseHelper;
    private final BeanDao beanDao;

    private MyDatabaseHelper() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper ( BaseApp.getInstance (), "bbean.db" );
        DaoMaster daoMaster = new DaoMaster ( devOpenHelper.getWritableDb ( ) );
        DaoSession daoSession = daoMaster.newSession ( );
        beanDao = daoSession.getBeanDao ( );
    }

    public static MyDatabaseHelper getMyDatabaseHelper() {
        if (myDatabaseHelper==null){
            synchronized (MyDatabaseHelper.class){
                if (myDatabaseHelper==null){
                    myDatabaseHelper =  new MyDatabaseHelper ();
                }
            }
        }
        return myDatabaseHelper;
    }

    public void insert(Bean bean){
        beanDao.insert ( bean );
    }
    public void delete(Bean bean){
        beanDao.delete ( bean );
    }
    public void deleteAll(List<Bean> list){
        beanDao.deleteAll ();
    }
    public List<Bean> queryAll(){
        List<Bean> list = beanDao.queryBuilder ( ).list ( );
        return list;
    }

}
