package br.com.erudio;

import br.com.erudio.exception.UnsupportedMathOperationException;
import org.springframework.web.bind.annotation.*;

@RestController
public class PersonController {

    @RequestMapping(value = "/sum/{x}/{y}", method = RequestMethod.GET)
    public Double sum(@PathVariable(value="x") String x, @PathVariable(value = "y") String y) {
        if(!isNumero(x) || !isNumero(y)){
            throw new UnsupportedMathOperationException("Por favor, adicione um valor numérico.");
        }
        return convertToDouble(x) + convertToDouble(y);
    }

    @RequestMapping(value = "/sub/{x}/{y}", method = RequestMethod.GET)
    public Double sub(@PathVariable(value="x") String x, @PathVariable(value = "y") String y) {
        if(!isNumero(x) || !isNumero(y)){
            throw new UnsupportedMathOperationException("Por favor, adicione um valor numérico.");
        }
        return convertToDouble(x) - convertToDouble(y);
    }

    @RequestMapping(value = "/mult/{x}/{y}", method = RequestMethod.GET)
    public Double mult(@PathVariable(value="x") String x, @PathVariable(value = "y") String y) {
        if(!isNumero(x) || !isNumero(y)){
            throw new UnsupportedMathOperationException("Por favor, adicione um valor numérico.");
        }
        return convertToDouble(x) * convertToDouble(y);
    }

    @RequestMapping(value = "/div/{x}/{y}", method = RequestMethod.GET)
    public Double div(@PathVariable(value="x") String x, @PathVariable(value = "y") String y) {
        if(!isNumero(x) || !isNumero(y)){
            throw new UnsupportedMathOperationException("Por favor, adicione um valor numérico.");
        }
        return convertToDouble(x) / convertToDouble(y);
    }

    @RequestMapping(value = "/ave/{x}/{y}", method = RequestMethod.GET)
    public Double ave(@PathVariable(value="x") String x, @PathVariable(value = "y") String y) {
        if(!isNumero(x) || !isNumero(y)){
            throw new UnsupportedMathOperationException("Por favor, adicione um valor numérico.");
        }
        return (convertToDouble(x) + convertToDouble(y)) / 2;
    }

    @RequestMapping(value = "/sqrt/{x}", method = RequestMethod.GET)
    public Double sqrt(@PathVariable(value="x") String x) {
        if(!isNumero(x)){
            throw new UnsupportedMathOperationException("Por favor, adicione um valor numérico.");
        }
        return (Double) Math.sqrt(convertToDouble(x));
    }

    private Double convertToDouble(String numero){
        if(numero != null){
            if(numero.contains(",")){
                numero = numero.replaceAll(",",".");
            }
            return Double.parseDouble(numero);
        }
        return 0D;
    }

    private boolean isNumero(String numero){
        if(numero != null){
            if(numero.contains(",")){
                numero = numero.replaceAll(",",".");
            }
            return numero.matches("[-+]?[0-9]*\\.?[0-9]");
        }
        return false;
    }
}
