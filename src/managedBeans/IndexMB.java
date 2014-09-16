package managedBeans;

import java.io.FileNotFoundException;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import model.Account;

@ManagedBean
@ViewScoped
public class IndexMB extends AbstractProcessosMB<Account> implements Serializable {

	/*
	public IndexMB() throws FileNotFoundException {
		super(new Account(),"index");
		// TODO Auto-generated constructor stub
	}
	*/
	
	public IndexMB(Class<Account> clazz) throws FileNotFoundException {
		super(clazz);
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 7145758767007167623L;

	public void logar() {
	}

	private Properties properties;

	private Account account = new Account();

	private List<Account> accountList = new ArrayList<Account>();

	@PostConstruct
	public void init() {
		accountList.add(addAcc("guilherme.giusti@hausdha", "p12asdasd", 1253L));
		accountList.add(addAcc("fulano@hausdha", "p12asdasd", 13L));
		accountList.add(addAcc("beutrano.giusti@hausdasdasdha", "asdasasda",
				1213L));
		accountList.add(addAcc("ciclano.giusti@hausdha", "asd", 13L));
		accountList.add(addAcc("mano.giusti@hausdha", "p12asdasd", 1L));
		accountList.add(addAcc("teste.giusti@hausdha", "asdasda", 3L));
		accountList.add(addAcc("asd.giusti@hausdha", "aaaa", 12390L));
		accountList.add(addAcc("abc.giusti@hausdha", "asaas", 1213L));
		accountList.add(addAcc("guilherme.giusti@hausdha", "asda", 1233L));
//		listTable = accountList;
//		setSelectedList(new ArrayList<Account>());
//		selected = new Account();
		properties = new Properties();
		properties.put("id", "Mudou");
//		setAvisoExcluir("Voce quer excluir os itens ?");
//		setAvisoPreExcluir("Os itens serão excluídos!!");
//		setPdfFileName("arquivo");
		// properties.put("email", "Email Destinario");

	}

	public Field[] getFieldsEntity() {
		return null;
	}

	public boolean verificarAnotacao(final String field, final String args) {
		return Arrays.asList(args.replace(" ", "").split(",")).contains(field);
	}

	public Account addAcc(final String email, final String password,
			final Long id) {
		Account acc = new Account();
		acc.setActive(true);
		acc.setEmail(email);
		acc.setId(id);
		acc.setPassword(password);
		acc.setPremmium(true);
		acc.setRegistryDate(Calendar.getInstance());
		return acc;
	}

	public List<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public Properties getProperties() {
		return properties;
	}

	public void setProperties(Properties properties) {
		this.properties = properties;
	}

	//@Override
	public String[] getArgs() {
		String[] s = {"email","id"};
		return s;
	}

	@Override
	public void loadDataTables() {
		// TODO Auto-generated method stub
		
	}

	
}
