import 'package:test/test.dart';
import 'package:openapi/openapi.dart';


/// tests for DefaultApi
void main() {
  final instance = Openapi().getDefaultApi();

  group(DefaultApi, () {
    // Search with a query
    //
    //Future<String> search(String q) async
    test('test search', () async {
      // TODO
    });

  });
}
