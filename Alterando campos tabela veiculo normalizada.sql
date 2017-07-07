declare  
  begin
     for marca in marca
      loop     
       update veiculo set idmarca where veiculo.marca = marca.nome;     
     end loop;
  end;
