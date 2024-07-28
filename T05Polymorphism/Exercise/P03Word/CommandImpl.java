package T05Polymorphism.Exercise.P03Word;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommandImpl implements CommandInterface {

    private class ToUpperTransform implements TextTransform {
        @Override
        public void invokeOn(StringBuilder text, int startIndex, int endIndex){
            for (int i = startIndex; i < endIndex; i++) {
                text.setCharAt(i, Character.toUpperCase(text.charAt(i)));
            }
        }
    }

    private class CutTransform implements TextTransform {
        @Override
        public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
            removedText.setLength(0);
            saveText(text, startIndex, endIndex);

            text.delete(startIndex, endIndex);
        }

        private void saveText(StringBuilder text, int startIndex, int endIndex) {
            for (int i = 0; i < text.length(); i++) {
                if (i > endIndex) {
                    break;
                }
                char currentChar = text.charAt(i);
                if (i >= startIndex && i < endIndex) {
                    removedText.append(currentChar);
                }
            }
        }
    }

    private class PastTransform implements TextTransform {

        @Override
        public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
              text.replace(startIndex, endIndex, removedText.toString());
        }
    }

    private Map<String, TextTransform> commandTransforms;
    private StringBuilder text;
    private StringBuilder removedText = new StringBuilder();

    public CommandImpl(StringBuilder text) {
        this.commandTransforms = new HashMap<>();
        this.text = text;
    }

    @Override
    public void init() {
        // Adding the commands to the map:
        this.commandTransforms.clear();
        List<Command> commands = this.initCommands();
        for (Command currentCommand : commands) {
            String comamndName = currentCommand.getText();
            TextTransform textTransform = currentCommand.getTextTransform();
            this.commandTransforms.putIfAbsent(comamndName, textTransform);
        }
    }

    @Override
    public void handleInput(String input) {
        // 1. Reading the commandName and the startIndex and the endIndex
        String[] tokens = input.split("\\s+");
        String commandName = tokens[0];
        int startInd = Integer.parseInt(tokens[1]);
        int endInd = Integer.parseInt(tokens[2]);

        // 2. Getting the textTransform by commandName and invokation of the method invokeOn():
        TextTransform textTransform = this.commandTransforms.get(commandName);
        textTransform.invokeOn(this.text, startInd, endInd);
    }


    protected List<Command> initCommands() {
        // 1. Creating a 3 commands and addint it to a list
        Command command1 = new Command("uppercase", new ToUpperTransform());
        Command command2 = new Command("cut", new CutTransform());
        Command command3 = new Command("paste", new PastTransform());

        return new ArrayList<>(List.of(command1, command2, command3));
    }
}
