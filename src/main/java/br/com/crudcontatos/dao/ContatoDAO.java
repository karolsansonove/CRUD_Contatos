package br.com.crudcontatos.dao;

import br.com.crudcontatos.factory.ConnectionFactory;
import br.com.crudcontatos.model.Contato;
import com.mysql.cj.jdbc.exceptions.MysqlDataTruncation;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ContatoDAO {
    public void save(Contato contato) {
        String sql = "INSERT INTO Contato(nome, telefone, dataCadastro) VALUES(?, ?, ?)";

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            ps = conn.prepareStatement(sql);

            ps.setString(1, contato.getNome());
            ps.setString(2, contato.getTelefone());
            ps.setDate(3, new Date(contato.getDataCadastro().getTime()));

            ps.execute();
            System.out.println("Cadastro realizado com sucesso!");
        } catch (MysqlDataTruncation e) {
            System.out.println("Os dados inseridos excedem o tamanho permitido.");
        } catch (Exception e) {
            System.out.println("Erro ao tentar inserir contato no banco.");
            e.printStackTrace();
        } finally {
            try {

                if (conn != null) {
                    conn.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch(Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void removeById(int id) {
        String sql = "DELETE FROM Contato WHERE id = ?";

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            ps = conn.prepareStatement(sql);

            ps.setInt(1, id);

            if (ps.executeUpdate() > 0) {
                System.out.println("\nContato removido.");
            } else {
                System.out.println("\nContato não encontrado.");
            }

        } catch (Exception e) {
            System.out.println("\nErro ao tentar remover contato: ");
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception e) {
                System.out.println("\nErro ao tentar fechar conexão e/ou declaração.");
            }
        }
    }

    public void update(Contato contato) {
        String sql = "UPDATE Contato SET nome = ?, telefone = ? WHERE id = ?";

        Connection conn = null;
        PreparedStatement ps = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            ps = conn.prepareStatement(sql);

            ps.setString(1, contato.getNome());
            ps.setString(2, contato.getTelefone());
            ps.setInt(3, contato.getId());

            ps.execute();
            if (ps.executeUpdate() > 0) {
                System.out.println("\nContato atualizado com sucesso!");
            } else {
                System.out.println("\nContato não encontrado.");
            }

        } catch (MysqlDataTruncation e) {
            System.out.println("\nOs dados inseridos excedem o tamanho permitido.");
        } catch (Exception e) {
            System.out.println("\nErro ao tentar atualizar contato.");
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (ps != null) {
                    ps.close();
                }
            } catch (Exception e) {
                System.out.println("\nErro ao tentar encerrar conexão.");
            }
        }
    }

    public List<Contato> getListaContatos() {
        List<Contato> contatos = new ArrayList<>();
        String sql = "SELECT * FROM Contato";
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            conn = ConnectionFactory.createConnectionToMySQL();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                Contato contato = new Contato();

                contato.setId(rs.getInt("id"));
                contato.setNome(rs.getString("nome"));
                contato.setTelefone(rs.getString("telefone"));
                contato.setDataCadastro(rs.getDate("dataCadastro"));

                contatos.add(contato);
            }

        } catch (Exception e) {
            System.out.println("\nErro ao tentar gerar lista de contatos.");
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (ps != null) {
                    ps.close();
                }
                if (rs != null) {
                    rs.close();
                }
            } catch (Exception e) {
                System.out.println("\nErro ao tentar encerrar conexões.");
            }
        }
        return contatos;
    }
}
