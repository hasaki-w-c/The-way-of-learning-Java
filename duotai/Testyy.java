package duotai;

/*
 * ��̬��ʵ�ʿ����е����ã�����������ι������Ϊ��˵����̬�����ã�
 *   1.����������ι�������������Ҫʵ����Ҫ������ĳ���
 *     -���ˡ��ࡿ
 *     -���˿���ι���������������ι�����������
 *     -����ࡿ
 *     -������ԳԶ����������гԶ����������
 *     
 *   2.��������̵ĺ��ģ�������࣬Ȼ����ʵ����Ϊ���󣬸�һ��������ʹһ�£��ø�������֮��Э�������γ�һ��ϵͳ��
 *   
 *   3.��̬��������ʲô��
 *       1.���ͳ������϶ȣ���߳������չ����
 *       2.��ʹ�ö�̬����ʹ�ö�̬��
 *       3.����������ָ�������Ͷ���
 *       
 *      ���ģ���������̣�������Ҫ��������̡�
 */
public class Testyy {

	public static void main(String[] args) {
		//�������˶���
		Zhuren wangchen = new Zhuren();
		//�����������
		Chongwu tom = new Chongwu();
		//����ι������
		wangchen.feed(tom);
		//����С������
		Dogcw erha = new Dogcw();
		//����ι��С��
		wangchen.feed(erha);
	}

}