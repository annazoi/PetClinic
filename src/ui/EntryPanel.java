package ui;

import java.awt.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.swing.*;
import entries.*;
import ui.*;

public class EntryPanel extends JPanel {
	
	private Entry entry;
	private JButton servicesButton;
	public static Service[] servicesList;
	private JButton checkoutButton;
	
	private JLabel totalPriceLabel;
	
	JCheckBox checkBox = new JCheckBox();

	private ArrayList<Service> selectedServices = new ArrayList<Service>();
	
	private static Map<Entry, JLabel> entryLabel;
	
	private ArrayList<Payment> paymentsData;
	
	public EntryPanel() {}
	
	public EntryPanel (Entry entry, Service[] services) {
		
		paymentsData = new ArrayList<Payment>();
		
		this.entry = entry;
		EntryPanel.servicesList = services;
		setLayout(new FlowLayout());
	
		JLabel nameLabel = new JLabel(entry.getName());
		JLabel introdateLabel = new JLabel(entry.getIntroDate()+"");
		
		add(nameLabel);
		add(introdateLabel);
		
		
		
		servicesList = new Service[]{
				new Service(10, 0.24, "Washing", "Animals", "washing for all pets"),
				new Service(20, 0.24, "grooming", "Dogs", "grooming for dogs only"),
				new Service(10, 0.24, "nail_clipping", "Animals", "making the shots to the pet"),
				new Service(20, 0.24, "shot", "Animals", "making the shots to the pet") 	
		};
		
		
		 servicesButton = new JButton("Services");
		 servicesButton.setFocusable(false);
		 servicesButton.setBackground(MainUIPage.light);
	     servicesButton.addActionListener(new ActionListener () {

			@Override
			public void actionPerformed(ActionEvent e) {
				servicesDialog();
			}
	    	 
	     });
	     
	    add(servicesButton);
		
		totalPriceLabel = new JLabel();
		add(totalPriceLabel);
		
		checkoutButton = new JButton("Checkout");
		checkoutButton.setBackground(MainUIPage.light);
		checkoutButton.setFocusable(false);
		checkoutButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JFrame peymentFrame = new JFrame();
				JPanel peymentPanel = new JPanel();
				JButton cashButton = new JButton("CASH");
				JButton creditButton = new JButton("CREDIT CARD");
				JButton bitcoinButton = new JButton("BITCOIN");
				
				peymentFrame.setVisible(true);
				peymentFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				peymentFrame.setSize(400, 200);
				peymentPanel.setBackground(MainUIPage.dark);
				peymentFrame.add(peymentPanel);
				
				cashButton.setBackground(MainUIPage.light);
				cashButton.setFocusable(false);
				cashButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						JFrame cashFrame = new JFrame("Cash Payment");
						JPanel cashPanel = new JPanel();
						
						JLabel coinLabel = new JLabel("Coin (e.g. euro)");
						JLabel numberLabel = new JLabel("Cash Number");
						JLabel priceLabel = new JLabel("Total Price");
						JLabel currentPriceLabel = new JLabel();
						
						JTextField coinText = new JTextField(40);
						JTextField cashNumberText = new JTextField(40);
						
						JButton finalButton = new JButton("Order Completion");
						cashFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						cashFrame.setSize(400, 200);
						cashFrame.setVisible(true);
						cashFrame.setBackground(MainUIPage.dark);
						
						cashPanel.setBackground(MainUIPage.dark);
						cashPanel.setLayout(null);
						cashFrame.add(cashPanel);
																	
						coinLabel.setBounds(10, 10, 200, 30);
						cashPanel.add(coinLabel);
						
						numberLabel.setBounds(10, 40, 200, 30);
						cashPanel.add(numberLabel);

						coinText.setBackground(MainUIPage.light);
						coinText.setBounds(180, 10, 180, 25);
						cashPanel.add(coinText);
						
						cashNumberText.setBackground(MainUIPage.light);
						cashNumberText.setBounds(180, 40, 180, 25);
						cashPanel.add(cashNumberText);
						
						priceLabel.setBounds(10, 70, 200, 30);
						displayTotalPrice();
						cashPanel.add(priceLabel);
						
						currentPriceLabel.setBounds(180, 70, 200, 25);
						currentPriceLabel.setText(Double.toString(totalPrice()));
						cashPanel.add(currentPriceLabel);
						
						finalButton.setBounds(180, 110, 180, 30);
						finalButton.setFocusable(false);
						finalButton.setBackground(MainUIPage.light);
						finalButton.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								String coin = coinText.getText();
								int cashNumber = Integer.parseInt(cashNumberText.getText());
								Date paymentDate = new Date();
								double paymentAmount = totalPrice();
								
								Payment cash = new CashPayment(paymentAmount, coin, paymentDate, cashNumber);
								paymentsData.add(cash);
								System.out.print(cash);
								
						        int orderMessage = JOptionPane.showConfirmDialog(cashPanel, "Order Completed Successfully!", "Order Status", JOptionPane.DEFAULT_OPTION);
							
							}
							
						});
						cashPanel.add(finalButton);
				
						
					}
					
				});
				peymentPanel.add(cashButton);
				
				creditButton.setBackground(MainUIPage.light);
				creditButton.setFocusable(false);
				creditButton.addActionListener(new ActionListener () {

					@Override
					public void actionPerformed(ActionEvent e) {
						JFrame creditFrame = new JFrame("Credit Card Payment");
						JPanel creditPanel = new JPanel();
						
						JLabel coinLabel = new JLabel("Coin (e.g. euro)");
						JLabel numberCardLabel = new JLabel("Number Card");
						JLabel codeLabel = new JLabel("Security code (***)");
						JLabel nameLabel = new JLabel("Owner Name");
						JLabel totalPriceLabel = new JLabel("Total Price");
						JLabel currentPriceLabel = new JLabel(Double.toString(totalPrice()));
						
						JTextField coinText = new JTextField(40);
						JTextField numberCardText = new JTextField(40);
						JTextField codeText = new JTextField(40);
						JTextField nameText = new JTextField(40);
						
						JButton finalButton = new JButton("Order Completion");
						
						creditFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						creditFrame.setSize(400, 250);
						creditFrame.setVisible(true);
						creditFrame.setBackground(MainUIPage.dark);
						
						creditPanel.setBackground(MainUIPage.dark);
						creditPanel.setLayout(null);
						creditFrame.add(creditPanel);
						
						coinLabel.setBounds(10, 10, 200, 30);
						creditPanel.add(coinLabel);
						
						numberCardLabel.setBounds(10, 40, 200, 30);
						creditPanel.add(numberCardLabel);
						
						codeLabel.setBounds(10, 70, 200, 30);
						creditPanel.add(codeLabel);
						
						nameLabel.setBounds(10, 100, 200, 30);
						creditPanel.add(nameLabel);
						
						totalPriceLabel.setBounds(10, 130, 200, 30);
						creditPanel.add(totalPriceLabel);

						coinText.setBackground(MainUIPage.light);
						coinText.setBounds(180, 10, 180, 25);
						creditPanel.add(coinText);
						
						numberCardText.setBackground(MainUIPage.light);
						numberCardText.setBounds(180, 40, 180, 25);
						creditPanel.add(numberCardText);
						
						codeText.setBackground(MainUIPage.light);
						codeText.setBounds(180, 70, 180, 25);
						creditPanel.add(codeText);

						
						nameText.setBackground(MainUIPage.light);
						nameText.setBounds(180, 100, 180, 25);
						creditPanel.add(nameText);
						
						currentPriceLabel.setBounds(180, 130, 180, 25);
						creditPanel.add(currentPriceLabel);
						
						finalButton.setBounds(180, 170, 180, 30);
						finalButton.setFocusable(false);
						finalButton.setBackground(MainUIPage.light);
						finalButton.addActionListener(new ActionListener () {

							@Override
							public void actionPerformed(ActionEvent e) {
								String coin = coinText.getText();
								int numberCard = Integer.parseInt(numberCardText.getText());
								int code = Integer.parseInt(codeText.getText());
								String name = nameText.getText();
								Date paymentDate = new Date();
								Double paymentAmount = totalPrice();
								String strCode = String.valueOf(code);
								int lenCode = strCode.length();
								
								
								
								if (lenCode > 3 || lenCode <= 2) {
									JOptionPane.showMessageDialog(creditPanel, "only 3-digit security code", "Invalid Security Code", JOptionPane.ERROR_MESSAGE);
									codeText.setText(null);
									
									
								} else {
									
									int orderMessage = JOptionPane.showConfirmDialog(creditPanel, "Order Completed Successfully!", "Order Status", JOptionPane.DEFAULT_OPTION);
									Payment credit = new CreditCardPayment(paymentAmount, coin, paymentDate, numberCard, name, code);
									paymentsData.add(credit);
									System.out.print(credit);
								}
								
							}
							
						});
						creditPanel.add(finalButton);
						
					}
					
				});
				peymentPanel.add(creditButton);
				
				bitcoinButton.setBackground(MainUIPage.light);
				bitcoinButton.setFocusable(false);
				bitcoinButton.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						JFrame bitcoinFrame = new JFrame("Bitcoin Payment");
						JPanel bitcoinPanel = new JPanel();
						
						JLabel coinLabel = new JLabel("Type of Coin");
						JLabel totalPriceLabel = new JLabel("Total Price");
						JLabel currentPriceLabel = new JLabel(Double.toString(totalPrice()));
												
						JTextField coinText = new JTextField(40);
						
						JButton finalButton = new JButton("Order Completion");
						
						bitcoinFrame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
						bitcoinFrame.setSize(400, 200);
						bitcoinFrame.setVisible(true);
						bitcoinFrame.setBackground(MainUIPage.dark);
						
						bitcoinPanel.setBackground(MainUIPage.dark);
						bitcoinPanel.setLayout(null);
						bitcoinFrame.add(bitcoinPanel);
						
						coinLabel.setBounds(10, 10, 200, 30);
						bitcoinPanel.add(coinLabel);
						
						totalPriceLabel.setBounds(10, 40, 200, 30);
						bitcoinPanel.add(totalPriceLabel);

						coinText.setBackground(MainUIPage.light);
						coinText.setBounds(180, 10, 180, 25);
						bitcoinPanel.add(coinText);
						
						currentPriceLabel.setBounds(180, 40, 180, 25);
						bitcoinPanel.add(currentPriceLabel);
						
						finalButton.setBounds(180, 80, 180, 30);
						finalButton.setFocusable(false);
						finalButton.setBackground(MainUIPage.light);
						finalButton.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								String coin = coinText.getText();
								double paymentAmount = totalPrice();
								Date paymentDate = new Date();
								int extraCharge = 2;
								
								Payment bitcoin = new BitcoinPayment(paymentAmount, coin, paymentDate, extraCharge);
								paymentsData.add(bitcoin);
								System.out.print(bitcoin);
								
								int orderMessage = JOptionPane.showConfirmDialog(bitcoinPanel, "Order Completed Successfully!", "Order Status", JOptionPane.DEFAULT_OPTION);
							}
							
						});
						bitcoinPanel.add(finalButton);
						
					}
					
				});
				peymentPanel.add(bitcoinButton);
								
			}
			
		});
		add(checkoutButton);
		
		servicesButton.setFocusable(false);
		servicesButton.setBackground(MainUIPage.light);
		
		selectedServices = new ArrayList<>();
		
		entryLabel = new HashMap<>();
		
	}
	
	public ArrayList<Service> getSelectedServices() {
		return selectedServices;
	}

	public void setSelectedServices(ArrayList<Service> selectedServices) {
		this.selectedServices = selectedServices;
	}
	
	public void addSelectedService(Service service) {
	        selectedServices.add(service);
	}
	
	public void displayTotalPrice () {
		double totalPrice = 0.0;
		for (Service s: getSelectedServices()) {
			totalPrice += s.getPrice();
		}
		totalPriceLabel.setText(" "+totalPrice);
	}
	
	public double totalPrice () {
		double totalPrice = 0.0;
		for (Service s : getSelectedServices()) {
			totalPrice += s.getPrice();
		}
		return totalPrice;
		
	}

	public void generateViewWithServices(Entry entry) {
		
		ArrayList<Service> selectedServices = getSelectedServices();
		StringBuilder sb = new StringBuilder();
		
		JLabel titleLabel = new JLabel();
		JLabel priceLabel = new JLabel();
		
		
		double totalPrice = 0.0;
		
		entryLabel.put(entry, titleLabel);
		
		
		MainUIPage.servicesPanel.add(titleLabel);
		
		sb.append(entry.getName()).append(" ");
		
		if (selectedServices.isEmpty()) {
            sb.append("No services selected");
        } else {
            for (Service service : selectedServices) {
                sb.append(service.getTitle()).append(", ");
                totalPrice += service.getPrice();
            }
            sb.setLength(sb.length() - 1);
        }
		
		titleLabel.setText(sb.toString());
		
	    priceLabel = entryLabel.get(entry);
	    priceLabel.setText(sb.toString() + "\nTotal Price: " + totalPrice + "$");
	}
	
    private void servicesDialog() {
        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(servicesList.length, 1));

        JCheckBox[] checkboxes = new JCheckBox[servicesList.length];
        for (int i = 0; i < servicesList.length; i++) {
            checkboxes[i] = new JCheckBox(servicesList[i].getTitle() + " - $" + servicesList[i].getPrice() + " For all: " +servicesList[i].getCategory());
            panel.add(checkboxes[i]);
        }

        int result = JOptionPane.showConfirmDialog(this, panel, "Services", JOptionPane.OK_CANCEL_OPTION,
                JOptionPane.PLAIN_MESSAGE);

        if (result == JOptionPane.OK_OPTION) {
            ArrayList<Service> selectedServices = new ArrayList<>();
            for (int i = 0; i < checkboxes.length; i++) {
                if (checkboxes[i].isSelected()) {
                    selectedServices.add(servicesList[i]);
                    addSelectedService(servicesList[i]);
                    displayTotalPrice();
                    
                }
            }

            generateViewWithServices(entry);
            
            JOptionPane.showMessageDialog(this, "Services selected!");
            
        }
    }
	


}	
