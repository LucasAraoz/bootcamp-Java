package com.Integrador2.dao;

import com.Integrador2.bo.MyException;
import com.Integrador2.bo.Producto;

public interface IOperacionesDB {
	void add() throws MyException;

	void remove();

	void modify();

	void list();

}
