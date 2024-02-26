/* This file was generated by SableCC (http://www.sablecc.org/). */

package cours6.syntax.analysis;

import java.util.*;
import cours6.syntax.node.*;

public class AnalysisAdapter implements Analysis
{
    private Hashtable<Node,Object> in;
    private Hashtable<Node,Object> out;

    @Override
    public Object getIn(Node node)
    {
        if(this.in == null)
        {
            return null;
        }

        return this.in.get(node);
    }

    @Override
    public void setIn(Node node, Object o)
    {
        if(this.in == null)
        {
            this.in = new Hashtable<Node,Object>(1);
        }

        if(o != null)
        {
            this.in.put(node, o);
        }
        else
        {
            this.in.remove(node);
        }
    }

    @Override
    public Object getOut(Node node)
    {
        if(this.out == null)
        {
            return null;
        }

        return this.out.get(node);
    }

    @Override
    public void setOut(Node node, Object o)
    {
        if(this.out == null)
        {
            this.out = new Hashtable<Node,Object>(1);
        }

        if(o != null)
        {
            this.out.put(node, o);
        }
        else
        {
            this.out.remove(node);
        }
    }

    @Override
    public void caseStart(Start node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAAddExp(AAddExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASubExp(ASubExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASimpleExp(ASimpleExp node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAMultFactor(AMultFactor node)
    {
        defaultCase(node);
    }

    @Override
    public void caseADivFactor(ADivFactor node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAModFactor(AModFactor node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASimpleFactor(ASimpleFactor node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAPosSign(APosSign node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANegSign(ANegSign node)
    {
        defaultCase(node);
    }

    @Override
    public void caseASimpleSign(ASimpleSign node)
    {
        defaultCase(node);
    }

    @Override
    public void caseANumTerm(ANumTerm node)
    {
        defaultCase(node);
    }

    @Override
    public void caseAParTerm(AParTerm node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTPlus(TPlus node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTMinus(TMinus node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTStar(TStar node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTSlash(TSlash node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTPercent(TPercent node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTLPar(TLPar node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTRPar(TRPar node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTNum(TNum node)
    {
        defaultCase(node);
    }

    @Override
    public void caseTBlank(TBlank node)
    {
        defaultCase(node);
    }

    @Override
    public void caseEOF(EOF node)
    {
        defaultCase(node);
    }

    @Override
    public void caseInvalidToken(InvalidToken node)
    {
        defaultCase(node);
    }

    public void defaultCase(@SuppressWarnings("unused") Node node)
    {
        // do nothing
    }
}
