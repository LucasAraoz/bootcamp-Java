package com.Integrador2.dao;

import com.Integrador2.bo.MyException;
import com.Integrador2.bo.Producto;

public interface IOperacionesDB {
	void add() throws MyException;// suma productos

	void remove(); // resta

	void modify();// quiere modificar stock precio

	void list();

}
