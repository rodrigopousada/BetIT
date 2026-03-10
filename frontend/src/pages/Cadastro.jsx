import React, {useState} from 'react';
import api from '../services/api';

function Cadastro() {
    const [formData, setFormData] = useState({nome: '', email: '', senha: ''});

    const handleSubmit = async (e) => {
        e.preventDefault();
        try {
        const response = await api.post('/usuarios/cadastrar', formData);
        alert('Usuario cadastrado com sucesso!');
        console.log(response.data);
        }catch(err) {
            console.log('Erro ao cadastrar', err);
            alert('Erro ao cadastrar!');
        }
    };

    return (
        <div style={{ padding: '20px', textAlign: 'center' }}>
            <h2>Bem-vindo ao BetIT!</h2>
            <form onSubmit={handleSubmit} style={{ display: 'inline-block', textAlign: 'left' }}>
                <div>
                    <label>Nome:</label><br/>
                    <input type="text" onChange={(e) => setFormData({...formData, nome: e.target.value})} />
                </div>
                <br/>
                <div>
                    <label>Email:</label><br/>
                    <input type="email" onChange={(e) => setFormData({...formData, email: e.target.value})} />
                </div>
                <br/>
                <div>
                    <label>Senha:</label><br/>
                    <input type="password" onChange={(e) => setFormData({...formData, senha: e.target.value})} />
                </div>
                <br/>
                <center><button type="submit">Cadastrar</button></center>
            </form>
        </div>
    );
}

export default Cadastro;